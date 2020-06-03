package cn.itlaobing.mybatis.sqlSession;

public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
