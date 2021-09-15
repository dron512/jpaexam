package com.jar.jpaexam.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Board {
    public Board(){}
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String title;
    private String content;

}
