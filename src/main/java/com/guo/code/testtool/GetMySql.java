package com.guo.code.testtool;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by gyf .
 * 16/8/25 .
 */
public class GetMySql {

//    public static void main(String[] args) throws Exception {
//        String str = " select %s as skinId, count(1) as appCount from tb_maila_app where skin_info like '%%\"idxSkinId\":%s,%%' ";
//        String union = " union ";
//        FileReader reader = new FileReader("/Users/gyf/Downloads/skin3.csv");
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        StringBuilder stringBuilder = new StringBuilder();
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            line = line.trim();
//            stringBuilder.append(String.format(str, line, line));
//            stringBuilder.append("\n");
//            stringBuilder.append(union);
//        }
//        System.out.println(stringBuilder.toString());
//    }

    public static void main(String[] args) throws Exception {
        String str = "http://mng.maila88.com/skin/delete?pwd=8eoCMrKVtJVXXJaNUYkp&id=%s";
        FileReader reader = new FileReader("/Users/gyf/Downloads/delete3.csv");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            stringBuilder.append(String.format(str, line));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
