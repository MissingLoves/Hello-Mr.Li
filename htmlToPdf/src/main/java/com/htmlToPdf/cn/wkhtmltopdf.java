package com.htmlToPdf.cn;



import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class wkthmltopdf {
    // wkhtmltopdf在系统中的路径
   private static final String toPdfTool = "D:\\wkhtmltox-0.12.5-1.mxe-cross-win64\\bin\\wkhtmltopdf.exe";
    //private static Object FileUtil;

    /**
     * html转pdf
     *
     * @param srcPath
     *            html路径，可以是硬盘上的路径，也可以是网络路径
     * @param destPath
     *            pdf保存路径
     * @return 转换成功返回true
     */
    public static String  convert(String srcPath, String destPath) {
        HttpServletRequest request= null;
        try {
            Process ps = Runtime.getRuntime().exec("where wkhtmltopdf.exe");
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));
        //wkhtmltopdf在系统中的路径
        String path ="";
        String text ="";
           // FileUtil.convertSystemFilePath("/home/ubuntu/wkhtmltox/bin/wkhtmltopdf");
        while ((text = br.readLine())!=null){
            path =text;
        }
        File file = new File(destPath);
        File parent = file.getParentFile();
        // 如果pdf保存路径不存在，则创建路径
        if (!parent.exists()) {
            //true代表拥有读写权限
            file.setWritable(true);
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
       /* if (!System.getProperty("os.name").contains("Windows")) {
            // 非windows 系统
            toPdfTool = FileUtil.convertSystemFilePath("/home/ubuntu/wkhtmltox/bin/wkhtmltopdf");
        }*/
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
        BufferedReader correct =null;
        //错误的返回信息
        BufferedReader error = null;
            Process proc = Runtime.getRuntime().exec(cmd.toString());



            //System.out.println(cmd.toString());

            /*correct = new BufferedReader(new InputStreamReader(proc.getInputStream(),Charset.forName("GBK")));
            error = new BufferedReader(new InputStreamReader(proc.getErrorStream(),Charset.forName("GBK")));*/


        } catch (Exception e) {
         System.out.println("失败");
        }
        return  destPath;

    }

    public static void main(String[] args) throws Exception {
       String url ="https://global.factiva.com/redir/default.aspx?P=sa&AN=ROMPES0020160215ec2f001up&cat=a&ep=ASE";
        String path ="D:\\test201905\\2211.pdf";
        String pdfath =convert(url,path);
        /*HtmlToPdfInterceptor f = new HtmlToPdfInterceptor(pdfath);
        f.run();*/
       /* File file1 = new File(pdfath);
        System.out.println(pdfath);
        if(!file1.exists()){
            System.out.println("转换失败");
        }else{
            System.out.println("转换成功");
        }*/

    }


}