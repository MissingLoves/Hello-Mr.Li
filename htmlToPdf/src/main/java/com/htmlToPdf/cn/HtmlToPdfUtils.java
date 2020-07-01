/*
package com.htmlToPdf.cn;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

*/
/**
 * @author Admin
 *//*


public class HtmlToPdfUtils {


    public static boolean convert(String srcPath, String destPath) throws IOException {
        File file = new File(destPath);
        File parent = file.getParentFile();
        // 如果pdf保存路径不存在，则创建路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        if (!System.getProperty("os.name").contains("Windows")) {
            // 非windows 系统
            //toPdfTool = FileUtil.convertSystemFilePath("/home/ubuntu/wkhtmltox/bin/wkhtmltopdf");
        }
        Process proc = Runtime.getRuntime().exec("where wkhtmltopdf.exe");
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(proc.getInputStream(), Charset.forName("GBK")));
        String path ="";
        String text ="";
        while ((text = br.readLine())!=null){
            path =text;
        }
        cmd.append(path);
        cmd.append(" ");
        cmd.append("  --header-line");//页眉下面的线
       //cmd.append(" --header-center 这里是页眉这里是页眉这里是页眉这里是页眉 ");//页眉中间内容
        cmd.append("  --margin-top 3cm ");// 设置页面上边距 (default 10mm)
        //cmd.append(" --header-html  file:///" + "https://blog.csdn.net/x6582026/article/details/53835835");// (添加一个HTML页眉,后面是网址)
        cmd.append(" --header-spacing 5 ");// (设置页眉和内容的距离,默认0)cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("  --header-line");//页眉下面的线
      //  cmd.append(" --header-center 这里是页眉这里是页眉这里是页眉这里是页眉 ");//页眉中间内容
        cmd.append("  --margin-top 3cm ");// 设置页面上边距 (default 10mm)
        //cmd.append(" --header-html  file:///" + "https://blog.csdn.net/x6582026/article/details/53835835");// (添加一个HTML页眉,后面是网址)
        cmd.append(" --header-spacing 5 ");// (设置页眉和内容的距离,默认0)
        cmd.append(" --footer-center 第[page]页／共[topage]页");//设置在中心位置的页脚内容
        //cmd.append(" --footer-html  file:///" + "https://blog.csdn.net/x6582026/article/details/53835835");// (添加一个HTML页脚,后面是网址)
        cmd.append(" --footer-line");// * 显示一条线在页脚内容上)
        cmd.append(" --footer-spacing 5 ");// (设置页脚和内容的距离)
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);

        boolean result = true;
        try {
            Process proc1 = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc1.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc1.getInputStream());
            System.out.println(error.toString());
            error.start();
            output.start();
            proc.waitFor();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }

        return result;

    }

public static void main(String args[]) throws IOException {

       String url ="https://www.jianshu.com/p/4d65857ffe5e/";//截取url最后子段作为文件名
       // String fileName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
       // System.out.println(fileName);
    HtmlToPdfUtils.convert(url,"D:\\test201905\\4d65857ffe5e.pdf");
}

    }

*/
