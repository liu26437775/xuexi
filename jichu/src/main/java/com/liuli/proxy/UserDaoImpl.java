package com.liuli.proxy;

public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
