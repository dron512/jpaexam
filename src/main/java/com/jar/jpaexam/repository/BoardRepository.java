package com.jar.jpaexam.repository;

import com.jar.jpaexam.Model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
