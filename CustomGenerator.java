package com.example.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CustomGenerator {
    public static void main(String[] args) {
        AutoGenerator msg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:\\IDEA\\wookSpeace\\src\\main\\java");
        gc.setFileOverride(true);
        //开启ActiveRecord模式
        gc.setActiveRecord(true);
        //xml二级缓存
        gc.setEnableCache(false);
        //生成基本的resultMap
        gc.setBaseResultMap(true);
        //生成基本的SQL片段
        gc.setBaseColumnList(true);
        gc.setAuthor("阿辉");
        gc.setIdType(IdType.AUTO);
        msg.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig ds = new DataSourceConfig();
        //设置数据库类型
        ds.setDbType(DbType.SQL_SERVER)
                .setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .setUrl("jdbc:sqlserver://DESKTOP-4CLJKOT:1433;DatabaseName=test")
                .setUsername("Sqladmin")
                .setPassword("admin");
        msg.setDataSource(ds);
        StrategyConfig sc = new StrategyConfig();
        sc.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel);
        msg.setStrategy(sc);
        PackageConfig pg = new PackageConfig();
        pg.setParent("com.example").setMapper("mapper").setEntity("entity").setService("server").setController("controller").setXml("mapper");
        msg.setPackageInfo(pg);
        msg.execute();

    }
}
