package com.example.voter.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "valid_voters")
public class Voter {

    @Id
    private String vvid;
    private String name;
    private int age;

    // Getters and Setters
    public String getVvid() {
        return vvid;
    }

    public void setVvid(String vvid) {
        this.vvid = vvid;
    }

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
}
