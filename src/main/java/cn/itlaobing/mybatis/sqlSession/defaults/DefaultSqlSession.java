package cn.itlaobing.mybatis.sqlSession.defaults;

import cn.itlaobing.mybatis.cfg.Configuration;
import cn.itlaobing.mybatis.sqlSession.SqlSession;
import cn.itlaobing.mybatis.sqlSession.proxy.MapperProxy;
import cn.itlaobing.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration config;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.config = configuration;
        connection = DataSourceUtil.getConnection(config);
    }

    /**
     * Proxy.newProxyInstance
     *
     * @param daoInterfaceClass 被代理对象的类加载器
     * @param <T>               类数组
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(config.getMappers(), connection));
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
