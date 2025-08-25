package com.example.test2;

public class Cat extends Animal {
    Cat() {

    }
    Cat(String name, int age, String number) {
        super(name, age, number);
    }
    
    public void standup() {
        System.out.println("고양이가 서 있습니다.");
    }

    public void sitdown() {
        System.out.println("고양이가 앉아 있습니다.");
    }

    public void run() {
        System.out.println("고양이가 달리고 있습니다.");
    }



}
