package com.sample.question;

import java.util.HashMap;
import java.util.Map;

public class StaticTest implements Cloneable{

    static int a = 5;
    static String name = "jitendra";


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("a","jitendra");

        System.out.println(map.putIfAbsent("b","raj"));
        System.out.println(map);

        map.compute("c",(a,b)->"test");
        System.out.println(map.computeIfPresent("c",(a,b)->"presentTest"));
        System.out.println(map.computeIfAbsent("d",(a)->"absentTest"));

        System.out.println(map);


        StaticTest test1 = new StaticTest();
        StaticTest test2 = new StaticTest();
        System.out.println(StaticTest.a);

        StaticTest.a = 10;
        System.out.println(StaticTest.a);
        System.out.println(test2.a);
        try {
            Object cloned = test1.clone();
            if(cloned instanceof StaticTest){
                StaticTest c = (StaticTest)cloned;
                System.out.println(c.a);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
