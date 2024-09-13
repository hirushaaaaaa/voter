package com.example.voter.data;

import jakarta.persistence.*;

@Entity
@Table(name = "voter")
public class Voter {

    @Id
    @Column (name = "vid")
    private String vid;
    @Column(name="name")
    private String name;
    @Column(name ="age")
    private int age;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
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
