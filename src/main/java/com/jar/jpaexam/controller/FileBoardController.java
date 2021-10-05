package com.jar.jpaexam.controller;

import com.jar.jpaexam.Model.FileBoard;
import com.jar.jpaexam.repository.FileBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("fileboard")
public class FileBoardController {

    @Autowired
    FileBoardRepository boardFileRepository;

    @GetMapping("list")
    public String list(Model model, @RequestParam(required = false,defaultValue = "0")int pagenum){
        if(pagenum !=0){
            pagenum--;
        }
        Page<FileBoard> page = boardFileRepository.findAll(PageRequest.of(pagenum,5, Sort.by("id").descending()));
        model.addAttribute("pagenum",pagenum);
        model.addAttribute("list",page);
        return "fileboard/list";
    }

    @GetMapping(value = "form")
    public String form(){
        return "fileboard/form";
    }

    @PostMapping(value = "form")
    public String form(Model model, List<MultipartFile> files){
        System.out.println(files);
//        Page<FileBoard> pagelist = boardFileRepository.findAll(PageRequest.of(0,1, Sort.by("id").descending()));
//        FileBoard board = pagelist.get().findFirst().orElse(new FileBoard());
//        long id = 0;
//        if(board.getId() != null)
//            id= board.getId()+1;
//
//
//        boardFileRepository.save(new FileBoard(id, "name", "title", "content","filename", null));
        return "redirect:/fileboard/list";
    }
}
