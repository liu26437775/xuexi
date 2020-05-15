package com.liuli.proxy;

import java.lang.reflect.Field;

public class UsetMain {
    public static void main(String [] aaa){
       /* System.out.println("---------------------普通模式----------------------------------");
        IUserDao iUserDao=new UserDaoImpl();
        System.out.println(iUserDao);
        iUserDao.save();
        iUserDao.query();
        System.out.println("---------------------通过静态代理----------------------------------");
        IUserDao iUserDao2=new UserDaoImpl();
        IUserDao iUserDaoproxy=new UserDaoProxy(iUserDao2);
        System.out.println(iUserDaoproxy);
        iUserDaoproxy.save();
        iUserDaoproxy.query();
 */
       System.out.println("---------------------jdk动态静态代理----------------------------------");
        IUserDao iUserDao3=new UserDaoImpl();
        IUserDao jdkProxy = (IUserDao) new JdkProxyFactory(iUserDao3).getProxyInstance();
        System.out.println(jdkProxy);
        /*jdkProxy.save();
        jdkProxy.query();*/

        TestAAA aaa1=new TestAAA();

        try {
            Field field = TestAAA.class.getDeclaredField("userDao");
            field.setAccessible(true);
            field.set(aaa1,jdkProxy);
        }catch (Exception e){
            e.printStackTrace();
        }
        aaa1.suibian();
      /* System.out.println("---------------------cglib动态静态代理----------------------------------");
        //目标对象
        UserDao target = new UserDao();
        //代理对象
        UserDao proxy = (UserDao)new CglibProxyFactory(target).getProxyInstance();
        System.out.println(proxy);
        //执行代理对象的方法
        proxy.save();
        proxy.query();*/

    }
}
