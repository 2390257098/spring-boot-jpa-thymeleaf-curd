package com;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-05-09 22:08
 **/
public class Test {
    public String gey(){
        return "我是刘慧斌";
    }
    public static void main(String[] args) {
        String i="a";
        int q=1;
        int w=1;
        //System.out.println();
        String b="a";
        String b1=new String("a");
        String b2=new String("a");
        /*System.out.println(i==b);
        System.out.println(i==b1);
        System.out.println(b1==b2);
        System.out.println(i.equals(b));
        System.out.println(b1.equals(b2));
        System.out.println(i.equals(b1));*/
        System.out.println(b1.equals(b2));
        System.out.println(b1==b2);
    }
}
