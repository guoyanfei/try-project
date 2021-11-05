package com.guo.code.torrent2magent;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gyf .
 * 2017/9/24 .
 */
public class MagentTool {

    public static void main(String[] args) throws Exception {
        MagentTool tool = new MagentTool();
        List<String> result = new ArrayList<>();
        List<String> result2 = tool.traverseFolder2("/Users/guoyanfei/Downloads/seeds", result);
        for (String it : result2) {
//            System.out.println(it);
            System.out.println(tool.getMagent(it));
        }
    }

    public String getMagent(String path) throws Exception {
        BInputStream in = new BInputStream();
        ByteArrayInputStream bin = in.getByteArrayInputStream(path);
        Map<String, Object> map = (Map<String, Object>) in.MapBtom(bin);
        BOutputStream out = new BOutputStream();
        byte[] bytes = out.Edi(map.get("info"));
        return "magnet:?xt=urn:btih:" + Sha1Hash.toHex(bytes);
    }

    public List<String> traverseFolder2(String path, List<String> result) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                return null;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder2(file2.getAbsolutePath(), result);
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        if (absolutePath.substring(absolutePath.length() - 8, absolutePath.length()).equals(".torrent")) {
                            result.add(absolutePath);
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        return result;
    }
}
