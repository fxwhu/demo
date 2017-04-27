package commonsTest;

import com.google.common.collect.Lists;

import java.io.File;
import java.net.URL;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class TestCopyUrl {

    public static void main(String[] args) throws Exception {
        RemoteUrl remoteUrl = new RemoteUrl("/api/config/file?app=ledou&env=uat&type=0&key=demo.properties&creator=common&version=1_0_0_0", Lists.<String>newArrayList("leconf.lefile.cn"));
        String fileString = "./test";
        String fileName = "demo.properties";
        String tmpPathFile = OsUtil.pathJoin(fileString, fileName);
        String tmpFilePath = MyStringUtils.getRandomName(tmpPathFile);
        File tmpFile = new File(tmpFilePath);
        for(URL url : remoteUrl.getUrls()){
            FileUtils.copyURLToFile(url, tmpFile);
        }
        File targetPath = new File(OsUtil.pathJoin(fileString, fileName));
        OsUtil.transferFileAtom(tmpFile, targetPath, false);


        OsUtil.makeDirs(ClassLoaderUtil.getClassPath());
        File targetFilePath = new File(OsUtil.pathJoin(ClassLoaderUtil.getClassPath(), fileName));


        OsUtil.transferFileAtom(tmpFile, targetFilePath, true);
    }
}
