package cn.itlaobing.mybatis.sqlSession.defaults;

import cn.itlaobing.mybatis.cfg.Configuration;
import cn.itlaobing.mybatis.sqlSession.SqlSession;
import cn.itlaobing.mybatis.sqlSession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.configuration = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
