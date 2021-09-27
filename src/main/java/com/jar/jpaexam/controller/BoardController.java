package com.jar.jpaexam.controller;

import com.jar.jpaexam.Model.Board;
import com.jar.jpaexam.Model.Board_tail;
import com.jar.jpaexam.repository.BoardRepository;
import com.jar.jpaexam.repository.BoardTailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "board")
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardTailRepository boardTailRepository;

    @GetMapping(value = "list")
    public String list(Model model, @RequestParam(required = false,defaultValue = "0")int pagenum){
        if(pagenum !=0){
            pagenum--;
        }
        Page<Board> page = boardRepository.findAll(PageRequest.of(pagenum,5, Sort.by("id").descending()));
        model.addAttribute("pagenum",pagenum);
        model.addAttribute("list",page);
        return "board/list";
    }

    @GetMapping(value = "form")
    public String form(Model model){
        Page<Board> pagelist = boardRepository.findAll(PageRequest.of(0,1,Sort.by("id").descending()));
        Board board = pagelist.get().findFirst().orElse(new Board());
        long id = 0;
        if(board.getId() != null)
            id= board.getId()+1;
        boardRepository.save(new Board(id, "name", "title", "content", null));
        return "redirect:/board/list";
    }

    @GetMapping(value = "formtail")
    public String formtail(Model model,Board_tail board_tail){
        System.out.println(board_tail);
        boardTailRepository.save(board_tail);
        return "redirect:/board/view?id="+board_tail.getBoard_id();
    }

    @GetMapping(value = "view")
    public String view(Model model,long id){
        Board board = boardRepository.findById(id).orElse(new Board());
//        for( Board_tail bt : board.getBoard_tailLists()){
//            System.out.println(bt);
//        }
        model.addAttribute("board",board);
        return "board/view";
    }


}
