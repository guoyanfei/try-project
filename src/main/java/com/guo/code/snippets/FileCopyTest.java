package com.guo.code.snippets;


import java.io.*;

public class FileCopyTest {

    public static void main(String[] args) throws IOException {
        String src = "/Users/gyf/Downloads/test.html";
        String dest = "/Users/gyf/Downloads/test2.html";
        FileCopyTest.copy(src, dest);
    }

    /**
     * 文件复制
     *
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copy(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0)
                out.write(buf, 0, n);
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}