package commonsTest;

import java.io.File;
import java.net.URL;

import static commonsTest.RemoteUrl.LOGGER;

/**
 * Created by fengxuan1 on 2016/12/19.
 */
public class DownLoadProperTiesAndMove {
    public String DownAndMove(RemoteUrl remoteUrl, String fileName, String localFileDir, String localFileDirTmp, int retryTimes,
                              int retrySleepSeconds){
        return null;
    }

    private File retryDownLoad(String localFileDirTmp, String fileName, RemoteUrl remoteUrl, int retryTimes, int retrySleepSeconds)
            throws Exception{
        if (localFileDirTmp == null) {
            localFileDirTmp = "./leconf/download";
        }
        String tmpFilePath = OsUtil.pathJoin(localFileDirTmp, fileName);
        String tmpFilePathUnique = MyStringUtils.getRandomName(tmpFilePath);
        File tmpFilePathUniqueFile = new File(tmpFilePathUnique);
        /*下载文件通过url*/
        retry4ConfDownload(remoteUrl, tmpFilePathUniqueFile, retryTimes, retrySleepSeconds);

        return  tmpFilePathUniqueFile;
    }


    /**
     * Retry封装 RemoteUrl 支持多Server的下载
     *
     * @param remoteUrl
     * @param localTmpFile
     * @param retryTimes
     * @param sleepSeconds
     *
     * @return
     */
    private Object retry4ConfDownload(RemoteUrl remoteUrl, File localTmpFile, int retryTimes, int sleepSeconds)
            throws Exception {

        for (URL url : remoteUrl.getUrls()) {

            // 可重试的下载
            UnreliableInterface unreliableImpl = new FetchConfFile(url, localTmpFile);

            try {

//                return retryStrategy.retry(unreliableImpl, retryTimes, sleepSeconds);

                return null;
            } catch (Exception e) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    LOGGER.info("pass");
                }
            }
        }

        throw new Exception("download failed.");
    }

}
