package cn.itlaobing;

import cn.itlaobing.dao.IUserDao;
import cn.itlaobing.instance.User;
import cn.itlaobing.mybatis.io.Resources;
import cn.itlaobing.mybatis.sqlSession.SqlSession;
import cn.itlaobing.mybatis.sqlSession.SqlSessionFactory;
import cn.itlaobing.mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapper.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builer = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builer.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        ///5.使用代理对象执行对应方法
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
