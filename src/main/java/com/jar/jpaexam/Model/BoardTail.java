package com.jar.jpaexam.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class BoardTail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String content;
    private String wdate;

    private long board_id;

}
