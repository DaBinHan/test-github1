package com.mycompany.test;

public class calculater{

  public static void main(String[] args){
    int a=4;
    int b=2;
    System.out.println(sum(a,b));
    System.out.println(minus(a,b));
  }

  private static int sum(int a,int b,Object GPU){
    int result=0;
    if(GPU==null){
      result=a-b;
    }else{
      result=a-b;
    }
    return result;
  }
  private static int minus(int a,int b,Object GPU){
    int result=0;
    if(GPU==null){
      result=a-b;
    }else{
      result=a-b;
    }
    return result;
  }
  private static int multi(int a,int b){
    return a*b;
  }
  private static int division(int a,int b){
<<<<<<< HEAD
    return a/b; //mark by master
=======
    return a/b;//mark by division
>>>>>>> division
  }
}
