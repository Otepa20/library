package com.library.entity;


import com.library.annotations.FileDesc;

@FileDesc(filename="users.txt")
public class User {

    private int id;
    private String name;

    public User(int i, int i1, int i2) {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
