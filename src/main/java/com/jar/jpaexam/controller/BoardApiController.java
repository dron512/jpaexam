package com.jar.jpaexam.controller;

import com.jar.jpaexam.Model.Board;
import com.jar.jpaexam.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("rest")
public class BoardApiController {

    @Autowired
    BoardRepository boardRepository;
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value="/list")
    public ResponseEntity<?> list(){
        List<Board> list = boardRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="insert")
    public String insert(){
        boardRepository.save(new Board(1l,"aa","bb","cc",null));
        boardRepository.save(new Board(2l,"aa","bb","cc",null));
        boardRepository.save(new Board(3l,"aa","bb","cc",null));
        boardRepository.save(new Board(4l,"aa","bb","cc",null));
        return "saved";
    }
}
