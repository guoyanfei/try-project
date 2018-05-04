package com.guo.code.urltool;

import java.io.*;

/**
 * Created by gyf .
 * 2018/2/22 .
 */
public class UrlTool {

    public static void main(String[] args) throws Exception {
        String pathname = "/Users/gyf/Downloads/fronted/test.html"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line;
        line = br.readLine();
        while (line != null) {
            line = br.readLine(); // 一次读入一行数据
            if (line == null) {
                continue;
            }
            String filePath = line.substring(0, line.lastIndexOf("/"));
            createDir("/Users/gyf/Downloads/fronted/" + filePath);

            String fileName = line.substring(line.lastIndexOf("/", line.length()));
            copyFile(new File("/Users/gyf/Downloads/temp/OwlAdmin/OwlAdmin_files" + fileName), new File("/Users/gyf/Downloads/fronted/" + line));
        }
    }

    public static void copyFile(File fromFile, File toFile) throws IOException {
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n = 0;
        while ((n = ins.read(b)) != -1) {
            out.write(b, 0, n);
        }

        ins.close();
        out.close();
    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }
}
