package com.liuli.proxy;

/**
 * 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    public void save() {
        System.out.println("通过静态代理执行前处理一些事情...");
        target.save();//执行目标对象的方法
        System.out.println("通过静态代理执行后处理一些事情...");
    }

    @Override
    public void query() {
        System.out.println("query通过静态代理执行前处理一些事情...");
        target.query();//执行目标对象的方法
        System.out.println("query通过静态代理执行后处理一些事情...");
    }


}
