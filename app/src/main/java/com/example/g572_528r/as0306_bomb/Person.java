package com.example.g572_528r.as0306_bomb;

import cn.bmob.v3.BmobObject;

/**
 * Created by g572-528r on 2017/3/6.
 */

public class Person extends BmobObject {
    private String name;
    private int age;
    private String address;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
