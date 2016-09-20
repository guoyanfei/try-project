package com.guo.code.testtool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gyf .
 * 16/9/1 .
 */
public class TestMyString {

    public static void main(String[] args) {
        String appTag = "美食,服装,学校,班级,姓名";

        List<String> pcgs = new ArrayList<>();
        String pcg1 = "美食,上街";
        String pcg2 = "好吃的,上街";
        String pcg3 = "服装,学校";
        String pcg4 = "我干";
        pcgs.add(pcg1);
        pcgs.add(pcg2);
        pcgs.add(pcg3);
        pcgs.add(pcg4);

        List<String> tags = Arrays.asList(appTag.split(","));

        Iterator<String> iterator = pcgs.iterator();
        while (iterator.hasNext()) {
            String it = iterator.next();
            List<String> temp = new ArrayList<>(Arrays.asList(it.split(",")));
            temp.retainAll(tags);
            if (!temp.isEmpty()) {
                iterator.remove();
            }
        }

        for (String it : pcgs) {
            System.out.println(it);
        }
    }
}
