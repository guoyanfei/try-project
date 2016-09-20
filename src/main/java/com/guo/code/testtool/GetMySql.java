package com.guo.code.testtool;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by gyf .
 * 16/8/25 .
 */
public class GetMySql {

    public static void main(String[] args) throws Exception {
        String str = " select id, consumer_id, flowwork_stage, type, status, order_num  from orders_%s where order_num = '%s' ";
//        String str = " select * from orders_%s where order_num = '%s' ";
        String union = " union ";
        FileReader reader = new FileReader("/Users/gyf/Downloads/orders.csv");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            int length = line.length();
            stringBuilder.append(String.format(str, line.substring(length - 4, length), line));
            stringBuilder.append(union);
        }
        System.out.println(stringBuilder.toString());
    }
}
