package com.bmss.IOTest;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by fengxuan1 on 2017/2/20.
 */
public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\");

        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(path, "*.txt");
            for (Path entry : paths) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
