package com.jar.jpaexam.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class FileBoardTail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String content;
    private String wdate;

    private long board_file_id;

}
