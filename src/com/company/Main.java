package com.company;

import java.lang.reflect.*;
import com.company.sad.asd;
/**
 * Created by Wil4 on 12.04.2017.
 */
public class Main {
    public static void main(String[] args) throws Throwable{
        Human human = new Human();
//        1 самый адекватный, топчик
        Class c1 = Class.forName("com.company.Human");
//        //2
//        Class<Human> c2 = (Class<Human>) human.getClass();
//        //3
//        Class c3 = Human.class;
//        Class in = int.class;
//        System.out.println(c1.getName());
//        System.out.println(c1.getSimpleName());

        int classModif = c1.getModifiers();
        //System.out.println(classModif);
        Constructor[] conHum = c1.getDeclaredConstructors();
        Constructor constructor =
                c1.getDeclaredConstructor(new Class[]{String.class});
        Class[] parameterTypes = constructor.getParameterTypes();
        for(Class con : parameterTypes){
            System.out.println(con.getSimpleName());
        }
        Constructor conHumans = Human.class.getDeclaredConstructor(String.class);
        conHumans.setAccessible(true);
        Human human1 = (Human)conHumans.newInstance("shket");
        System.out.println(human1);

    }
}
/*
1) инспекция
2) использование
3) изменение структуры объекта
*/

 class Human{
    private String name;
    public int age;

     public Human() {
     }

     public Human(String name, int age) {
         this.name = name;
         this.age = age;
     }

     private Human(String name) {
         this.name = name;
     }

     private void sayHello(){
        System.out.println("Hello, i'm private method");
    }
    public void sayH(){
        System.out.println("Hello, i'm public method");
    }
}