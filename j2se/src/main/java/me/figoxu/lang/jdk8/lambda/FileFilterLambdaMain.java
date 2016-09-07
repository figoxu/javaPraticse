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
public class FileFilterLambdaMain {
    public static void main(String[] args) {
        FileFilter directorFilter = (File f)-> f.isDirectory();
        for(File file:new File("D:/").listFiles(directorFilter)){
            System.out.println(file.toString());
        }
    }
}
