package me.figoxu.sample.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;


public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("HADOOP_USER_NAME","hadoop");
        String hdfs_path = "hdfs://172.23.6.3:8020/test7.txt";//文件路径
        String inpath = "/home/figo/develop/env/WORKSPACE/figoxu.github/javaPraticse/hadoop/hdfs/doc/append.txt";
        append(hdfs_path, inpath);
        append(hdfs_path, "/home/figo/develop/env/WORKSPACE/figoxu.github/javaPraticse/hadoop/hdfs/doc/append2.txt");
    }

    private static void append(String hdfs_path,  String inpath) {
        Configuration conf = new Configuration();
        conf.setBoolean("dfs.support.append", true);
        conf.setStrings("HADOOP_USER_NAME","root");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(URI.create(hdfs_path), conf);
            //要追加的文件流，inpath为文件
            InputStream in = new
                    BufferedInputStream(new FileInputStream(inpath));
            OutputStream out = fs.append(new Path(hdfs_path));
            IOUtils.copyBytes(in, out, 4096, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  