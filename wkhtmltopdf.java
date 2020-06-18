package com.example.util;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

class wkthmltopdf {
    /**
     * wkhtmltopdf.exe在系统中的路径
     */
    private static final String toPdfTool = "D:\\wkhtmltox-0.12.5-1.mxe-cross-win64\\bin\\wkhtmltopdf.exe";


    /**
     * html转pdf
     *
     * @param srcPath  html路径，可以是硬盘上的路径，也可以是网络路径
     * @param destPath pdf保存路径
     * @return 转换成功返回true
     */
    public static void convert(String srcPath, String destPath) {
        HttpServletRequest request = null;
        try {
            Process ps = Runtime.getRuntime().exec("where wkhtmltopdf.exe");
            BufferedReader br = null;
            File file = new File(destPath);
            if (file.exists()) {
                file.mkdirs();
            }
            br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));

            //wkhtmltopdf在系统中的路径
            String path = "";
            String text = "";
            // FileUtil.convertSystemFilePath("/home/ubuntu/wkhtmltox/bin/wkhtmltopdf");
            while ((text = br.readLine()) != null) {
                path = text;
            }

            StringBuilder cmd = new StringBuilder();

            cmd.append(path);
            cmd.append(" ");
            //页眉下面的线
            cmd.append("  --header-line");
            //设置页面上的边距
            cmd.append("  --margin-top 3cm ");
            // (设置页眉和内容的距离,默认0)
            cmd.append(" --header-spacing 5 ");
            //设置在中心位置的页脚内容
            cmd.append(" --footer-center 第[page]页／共[topage]页");
            // * 显示一条线在页脚内容上)
            cmd.append(" --footer-line");
            // (设置页脚和内容的距离)
            cmd.append(" --footer-spacing 5 ");
            //要转换的URL链接地址
            cmd.append(srcPath);
            cmd.append(" ");
            //pdf存放路径
            cmd.append(destPath);
            boolean result = true;
            //正确的返回信息
            BufferedReader correct = null;
            //错误的返回信息
            BufferedReader error = null;
            Process proc = Runtime.getRuntime().exec(cmd.toString());
        } catch (Exception e) {
            System.out.println("失败");
        }
    }

    public static List<String> readerUrl(String filePath) {
        File file = new File(filePath);
        BufferedReader br = null;
        String url = null;
        List<String> urlpath = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(file));
            while ((url = br.readLine()) != null) {
                urlpath.add(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlpath;
    }

    public static void main(String[] args) throws Exception {
      /*  String path = "D:/测试文件/PDF/";
        String ID = FiletTest.getFileDir("D:\\测试文件\\ID");
        String URL = FiletTest.getFileDir("D:\\测试文件\\URL");
        List<String> Urllist = readerUrl(URL);
        List<String> listId = readerUrl(ID);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
        Date newDay = new Date();
        path = path + sdf.format(newDay.getTime());
        System.out.println(path);
        File papers = new File(path);
        if (!papers.exists()) {
            papers.mkdirs();
        }
        for (int i = 0; i < Urllist.size(); i++) {
            int number = (int) ((Math.random() * 9 + 1) * 100000);
            String  newPath = path + listId.get(i) + "-" + number + ".pdf";

        }*/
        wkthmltopdf. convert("http://www.fontawesome.com.cn/cheatsheet/" ,"D:\\测试文件\\PDF\\123.pdf");

    }
}