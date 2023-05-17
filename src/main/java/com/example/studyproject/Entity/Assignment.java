package com.example.studyproject.Entity;

import jakarta.persistence.*;

@Entity
public class Assignment {


    //PK 지정
    @Id
    //데이터베이스에 따라 자동으로 ID가 지정 - 기본 세팅
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column
    private String startdate;
    public String getStartdate() {
        return startdate;
    }
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @Column
    private String finishdate;
    public String getFinishdate() {
        return finishdate;
    }
    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    @Column
    private float progress;
    public float getProgress() {
        return progress;
    }
    public void setProgress(float progress) {
        this.progress = progress;
    }


}
