package cn.itlaobing.mybatis.sqlSession;

import cn.itlaobing.mybatis.cfg.Configuration;
import cn.itlaobing.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import cn.itlaobing.mybatis.utils.XMLConfigBuilder;


import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
