package com.security;

/**
 * @author xueshiqi
 * @since 2019/3/18
 */
public class AClass {
    int a;
    String b;
    String c;

    @Override
    public String toString() {
        return "AClass{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }

    public AClass(int a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public AClass() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
