package com.example.app.entity;

class A {
    public static void main(String[] args) {
        UserJava user=new UserJava();
        String userName=user.getUsername();
        user.setUsername("aaa");
        //如果我们不想用get方法访问成员变量，而是使用.变量名称直接访问
        //那么我们需要在变量上加一个@JvmField
        //这样就只会生成一个公开的属性，而不会生成它的get和set
        String password=user.password;
    }
}
