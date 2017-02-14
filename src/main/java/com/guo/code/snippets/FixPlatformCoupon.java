package com.guo.code.snippets;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyf .
 * 2016/12/30 .
 */
public class FixPlatformCoupon {

    public static void main(String[] args) throws Exception {
        InputStreamReader read = new InputStreamReader(new FileInputStream(new File("/Users/gyf/Downloads/pcg.txt")), "utf-8");//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        List<String> content = new ArrayList<>();
        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            content.add(lineTxt);
        }
        CloseableHttpClient client = HttpClientBuilder.create().build();
        for (String it : content) {
            HttpPost post = new HttpPost("http://mng.duiba.com.cn/platFormCoupon/switchPCG?id=" + it + "&switch_pcg=false");
            post.setHeader("Cookie", "jsdata2=91roY6qbguBUK8bhgzQXL7xXGhfPudz1RNPfgYzDBn");
            post.setConfig(RequestConfig.custom().setConnectTimeout(3000).setConnectionRequestTimeout(3000).setSocketTimeout(3000).build());
            CloseableHttpResponse response1 = null;
            response1 = client.execute(post);
            String body1 = EntityUtils.toString(response1.getEntity());
            System.out.println(body1 + "----" + it);
        }
        read.close();
    }

}
