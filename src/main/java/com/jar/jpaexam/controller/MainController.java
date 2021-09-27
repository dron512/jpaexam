package com.jar.jpaexam.controller;

import com.jar.jpaexam.Model.Member;
import com.jar.jpaexam.dto.MemberFormDto;
import com.jar.jpaexam.repository.MemberRepository;
import com.jar.jpaexam.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping(value = "/")
    public String main(Model model) {

        MemberFormDto dto = new MemberFormDto();
        dto.setAddress("서울시 마포구 합정동");
        dto.setEmail("aa@naver.com");
        dto.setName("홍길동");
        dto.setPassword("1234");
        Member member = Member.createMember(dto, passwordEncoder);
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
//            throw new IllegalStateException("이미 가입된 회원입니다.");
        } else {
            memberService.saveMember(member);
        }

        return "main";
    }

}