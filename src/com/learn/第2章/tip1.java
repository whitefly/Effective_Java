package com.learn.第2章;

/**
 * 用静态工厂方法来代替构造器
 */

class Person {

    private Person() {
    }

    public static Person newInstance() {
        return new Person();
    }
}


public class tip1 {
    //使用静态工厂方法来创建类,这样每一个返回的类,都可以被记录.后期可以被控制(比如线程池,获取集体销毁)
    public static void main(String[] args) {
        Person person = Person.newInstance();
    }
}
