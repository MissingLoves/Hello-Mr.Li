package com.htmlToPdf.cn;

import org.junit.Test;

import java.io.File;

public class TestFile {

    @Test
    public void checkFile(){
        File fiel =new File("D:\\test201905\\1122.pdf");
        if(fiel.exists()){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}
