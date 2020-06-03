package cn.itlaobing.dao;

import cn.itlaobing.instance.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
