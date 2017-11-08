package com.example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chu on 2017/11/06.
 */
@Data
@Entity // ①
public class Player {
    @Id // ②
    private Integer id;
    private String name;
    private Integer age;
    private String team;
    private String position;

}