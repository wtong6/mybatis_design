package cn.itlaobing.mybatis.sqlSession.proxy;

import cn.itlaobing.mybatis.cfg.Configuration;
import cn.itlaobing.mybatis.cfg.Mapper;
import cn.itlaobing.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.connection = conn;
    }

    /**
     * 增强的方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //得到增强的方法名称
        String methodName = method.getName();
        //得到增强方法所在类的类名
        String className = method.getDeclaringClass().getName();
        //类名+方法名作为key
        String key = className + "." + methodName;
        //通过key得到value
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传入参数有误");
        }
        return new Executor().selectList(mapper, connection);
    }
}
