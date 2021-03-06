package com.liuli.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMain {


    public static void main(String [] aaa){
        System.out.println("---------------------普通模式----------------------------------");
        User user=new User();

        System.out.println(user);
        //通过java反射处理
        System.out.println("---------------------通过反射获取变量----------------------------------");

        //对私有方法做更改。
        Field[] fields= User.class.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            System.out.println("变量="+fields[i].toGenericString());
        }
        //对私有方法做更改。
        Method[] methods= User.class.getMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println("fangfa="+methods[i].getName());
        }
        System.out.println("---------------------通过反射赋值----------------------------------");
        try {
            //java反射赋值，是因为有些对象没有提供set方法，但是又需要赋值，怎么办，通过java反射实现";


            Field userField= User.class.getDeclaredField("userName");
            //获取到公共类的方法 Field userField= User.class.getField("userName");
            System.out.println(userField.getName());
            userField.setAccessible(true);//设置属性可以访问
            userField.set(user,"李四");


            Field ageField= User.class.getDeclaredField("age");
            ageField.setAccessible(true);//设置属性可以访问
            ageField.set(user,30);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
