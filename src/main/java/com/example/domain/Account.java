package com.example.domain;

/**
 * Created by chu on 2017/11/06.
 */

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by chu on 2017/11/06.
 */
@Data
@Entity // ①
public class Account {
    @Id // ②
    private Integer id;
    private String name;
    private String password;
    private String role;
}