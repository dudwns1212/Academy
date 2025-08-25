package com.example.test2;

public class Animal {
    public String name;
    public int age;
    public String number;

    public Animal() {

    }

    public Animal(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public void standup() {
        System.out.println("동물이 서 있습니다.");
    }

    public void sitdown() {
        System.out.println("동물이 앉아 있습니다.");
    }

    public void run() {
        System.out.println("동물이 달리고 있습니다.");
    }

}
