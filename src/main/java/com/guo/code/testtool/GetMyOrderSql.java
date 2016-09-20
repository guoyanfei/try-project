package com.guo.code.testtool;

/**
 * Created by gyf .
 * 16/9/15 .
 */
public class GetMyOrderSql {

    public static void main(String[] args) {
        String sql1 = " SELECT * FROM `ngame_orders_0000` WHERE `id` = 50815659 ";
        String sqln = "\n union SELECT * FROM `ngame_orders_%s` WHERE `id` = 50815659 ";
        StringBuilder sb = new StringBuilder();
        sb.append(sql1);
        for (int i = 0; i < 1024; i++) {
            sb.append(String.format(sqln, getPrefix(i)));
        }
        System.out.println(sb);
    }

    private static String getPrefix(int i) {
        if (i < 10) {
            return "000" + i;
        }
        if (i < 100) {
            return "00" + i;
        }
        if (i < 1000) {
            return "0" + i;
        }
        return "" + i;
    }
}
