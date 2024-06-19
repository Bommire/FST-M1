package com.example.Activity;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
           
            File file = new File("fst-m1-java/src/Java 4 session");
            boolean fStatus = file.createNewFile();
            if(fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }

            File fileUtil = FileUtils.getFile("fst-m1-java/src/Java 4 session");
            System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
            File destDir = new File("resources");
            FileUtils.copyFileToDirectory(file, destDir);
            File newFile = FileUtils.getFile(destDir, "Test.txt");
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("Data in test file: " + newFileData);
        } catch(IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}