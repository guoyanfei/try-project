package com.guo.code.torrent2magent;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gyf .
 * 2017/9/24 .
 */
public class BInputStream {

    private Charset cn = Charset.forName("utf-8"); //这是全局定义的

    public ByteArrayInputStream getByteArrayInputStream(String filePath) throws Exception {
        File BFiles = new File(filePath); //一个种子文件
        if (BFiles.isFile()) {  //文件有 就进去。
            ByteArrayOutputStream out = new ByteArrayOutputStream(); //创建个Byte数组的输出流
            FileInputStream Fsin = new FileInputStream(BFiles);
            byte[] b = new byte[50];  //临时缓存50个byte
            int len = 0;
            while ((len = Fsin.read(b)) >= 0) {
                out.write(b, 0, len); ///而将这些从FileInputStream里读出的byte[] 放到Byte数组的输出流里，它们全部储存在内存里，放心!! 种子数据量小，没事。
                ///直到读完为止。
            }
            Fsin.close();  //文件输入流可以关了 没用了。
            //到这里，先别关闭输出流。我们得把输出流转为输入流..........
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            ///  这句转换是整个程序，最有趣的部分。
            out.flush();  //就好像接力棒一下，交给另一个人之后就可以歇息了。
            out.close();
            return in;  //返回一个预读的输入流
        } else {  //如果没有种子文件 返回空的。
            return null;
        }
    }

    public String Onebyte(int Spk, ByteArrayInputStream bin) throws IOException { // 单独写个方法 更加好处理

        byte[] b = new byte[Spk];  //Spk  多少个byte

        int len = bin.read(b);   //在临时输入流里 读多少个byte  bin输入流是 全局定义的。

        return new String(b, 0, len);  //byte 转 字符串

    }

    public Object Strimgorbyte(String s1x, ByteArrayInputStream bin) throws IOException {

        while (true) {

            String ni = Onebyte(1, bin);   // 我这里又直接调用上面的方法去读  1 byte

            if (ni.equals(":")) {  //读到冒号为止结束，因为冒号前面是数字就是字符串长度

                break;

            } else {

                s1x += ni;    //那么将一个一个数字，拼在一起。

            }

        }

        int len = Integer.parseInt(s1x);  //读出来是字符串 转 整数  = 该字符串有几位（几个byte）

        byte[] b = new byte[len];  //临时byte  = 要读的长度 byte

        bin.read(b);  //读取

        int ts = 0;   //之后我做了一个判断  判断这个字符串是不是特殊字符，用来看看是不是二进制，就是那些看似乱码的东西。

        for (int i = 0; i < b.length; i++) {

            if (b[i] < 0) { //小于的话    等于不正常的字符，特殊的。

                ts = 1;  //它是特殊的

                break;

            }

        }

        if (ts == 0) {  //如果不特殊的字符串  转 UTF-8

            CharBuffer cf = cn.decode(ByteBuffer.wrap(b, 0, len));  //这就不会出现乱码，坑爹情况了。我之前都不知道了。

            return new String(cf.array(), 0, cf.limit());

        } else {  //如果特殊的 就是二进制的话直接byte数组返回。

            return b;

        }

    }

    public long Integmr(ByteArrayInputStream bin) throws IOException {  //整数类型开始先

        String thlen = "";

        while (true) {

            String ni = Onebyte(1, bin);   // 你看我这里直接调用上面的方法去读  1 byte

            if (ni.equals("e")) {  // i 之后一个一个字节（数字）去读取 读到e结束。

                break;

            } else { //没到e结束符的话  将它们拼在一起，最后不就形成一个数了。

                thlen += ni;

            }

        }

        return Long.parseLong(thlen);   //long类型最大，把它强转成long来放，因为不知道往后还有多少个。

    }

    public Object MapBtom(ByteArrayInputStream bin) throws IOException {   //解码时，就直接调用这个方法足矣。

        if (bin != null) {

            String ni = Onebyte(1, bin);  //读取1个byte 又是调用上面的方法。

            if (ni.equals("d")) { ///如果是字典类型

                Object key = MapBtom(bin);  //键 key   MapBtom()读回自己的方法重点也是这全是自我调用产生的结果。 自我调用的时候，又会判断，直到完成为止。

                Map<String, Object> mapnodes = new LinkedHashMap<String, Object>();  //创建一个有序的map去装

                while (key != null) {  ///循环到全部装完为止。       1

                    Object value = MapBtom(bin);    //自我调用 读值 value

                    mapnodes.put(key.toString(), value);  //键 值  插入

                    key = MapBtom(bin);  //又 读键key 因为循环模式 又回到1那。

                }

                // 读到没有为止，就返回终极Map。

                return mapnodes;

            } else if (ni.equals("l")) {  //如果是列表类型

                Object value = MapBtom(bin); //又自我调用 读值

                List<Object> nva = new ArrayList<Object>();  //用个List 去 装它们。

                while (value != null) {  //读到没有为止 返回

                    nva.add(value);

                    value = MapBtom(bin);  //又自我调用看看还有没有值是 属于这个List的

                }

                return nva;

            } else if (ni.equals("i")) {   ///如果是数字类型、int类型的话直接掉用上面的方法。

                return Integmr(bin);   //调用上面的方法

            } else if (ni.equals("e")) {  ///如果是e开始的话、表示该字段、列表、数字、字典处理完毕了 结束符

                return null;   //返回空  帮助上面的死循环体 得以跳出、

            } else {   //如果不是以上类型的 就是字符串或二进制 ， 字符串开头判断不了 ， 它是中间判断的。

                return Strimgorbyte(ni, bin);  //调用上面的方法

            }

        }

        return null;    ///如果流都是空的，那根本就没数据了，还搞毛啊。必须null。

    }

}
