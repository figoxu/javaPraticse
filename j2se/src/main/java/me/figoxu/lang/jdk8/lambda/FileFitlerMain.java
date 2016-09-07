package me.figoxu.lang.jdk8.lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * Created with IntelliJ IDEA.
 * User: figo
 * Date: 16-9-7
 * Time: 上午11:55
 * To change this template use File | Settings | File Templates.
 */
public class FileFitlerMain {

    public static void main(String[] args) {
        File dir = new File("D:/");
        FileFilter directoryFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] dirs = dir.listFiles(directoryFilter);
        for(File file:dirs){
            System.out.println(file.toString());
        }
    }
}
