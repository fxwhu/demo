package com.bmss.curator.test;

import com.google.common.collect.Lists;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by fengxuan1 on 2017/3/6.
 */
public class ZkClientTest {

    private static Logger logger = LoggerFactory.getLogger(ZkClientTest.class);


    public static void main(String[] args) throws Exception {
        creatNode();

        List<Thread> threads = Lists.newArrayList();
        List<CuratorFramework> clients = Lists.newArrayList();
        final List<LeaderLatch> leaderLatches = Lists.newArrayList();
        int times = 10;


        for (int i = 0; i < times; i++) {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            final CuratorFramework client = CuratorFrameworkFactory.newClient(Constants.ZKADDRESS, retryPolicy);

            final int j = i;
            client.start();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LeaderLatch leaderLatch = new LeaderLatch(client, "/leader", "#client" + j);
                    try {
                        leaderLatch.start();
                        leaderLatches.add(leaderLatch);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            clients.add(client);

            LeaderLatch currentLeader = null;
            for (int k = 0; k < times; k++) {
                if(leaderLatches.get(k).hasLeadership()){
                    currentLeader = leaderLatches.get(k);
                    break;
                }

            }

            System.out.println("current leader: " + currentLeader.getId());

            try {
                currentLeader.close();
                leaderLatches.get(0).await(10, TimeUnit.SECONDS);
                System.out.println("the new leader:" + leaderLatches.get(0).getLeader().getId());
            }catch (IOException e) {
                e.printStackTrace();}
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                for (LeaderLatch exampleClient : leaderLatches) {
                    CloseableUtils.closeQuietly(exampleClient);
                }
                for (CuratorFramework newclient : clients) {
                    CloseableUtils.closeQuietly(newclient);
                }

            }


        }
        Thread.sleep(1000);



    }


    public static void creatNode() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(Constants.ZKADDRESS, retryPolicy);
        client.start();
        client.create().forPath("/leader", "myData".getBytes());
        client.close();

    }
}
