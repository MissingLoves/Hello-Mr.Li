package com.example.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author Admin
 */
@Component
public class FileDelete {
    @Scheduled(cron = "0 20 10 * * ?")
    public void deleteFile() {
        String newFile =StringUtil.newFile();
        String allFile = "D:\\测试文件\\PDF\\"+newFile;
        File fis = new File(allFile);
        File[] file = fis.listFiles();
        int count = 0;
        if (fis != null) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].length() <= 40000) {
                    System.out.println("开始删除");
                    file[i].delete();
                    count++;
                }
            }
            System.out.println("共删除" + count + "条");
        }
    }

}
