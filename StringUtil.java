package com.example.util;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringUtil {
    /**
     * 删除多余的空白文本
     * @param file_path1 要删除有空白文本的内容
     * @param file_path2 删除后要重新保存的文本
     */
     public static void delete_blank_line(String file_path1,String file_path2){
        File file= new File(file_path2);
        if(file.exists()){
            file.delete();
        }
         InputStream in = null;
         BufferedReader br = null;
         FileWriter writer= null;
         try {
             in = new BufferedInputStream(new FileInputStream(file_path1));
             br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
             writer = new FileWriter(file_path2,true);
             String text ;
             while ((text=br.readLine())!=null){
                 if("".equals(text)){
                     continue;
                 }else {
                     writer.write(text+"\r\n");
                 };
             }
         }catch (Exception e){
             e.printStackTrace();
         }
     }
     //生成当天最新文件
    public static String newFile(){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
         Date date = new Date();
         String newDay = sdf.format(date.getTime());
         return newDay;
    }

    public static String getFileDir(String filePath) {

        File file = new File(filePath);
        File[] allFile = file.listFiles();
        String fileName = "";
        if (allFile.length > 0) {
            //获取当前系统时间
            Format fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            String newFileTime = "";
            for (int i = 0; i < allFile.length; i++) {
                //设置文件最后一次修改的时间
                calendar.setTimeInMillis(allFile[i].lastModified());
                if (fmt.format(calendar.getTime()).compareTo(newFileTime) > 0) {
                    newFileTime = fmt.format(calendar.getTime());
                    fileName = allFile[i].getName();
                    //System.out.println(fileName);
                }

            }
            System.out.println(filePath + "\\" + fileName);

        } else {
            System.out.println("该目录下没有文件");
        }
        return filePath + "/" + fileName;
    }
}
