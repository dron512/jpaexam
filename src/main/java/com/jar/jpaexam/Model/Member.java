package com.jar.jpaexam.Model;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import com.jar.jpaexam.constant.Role;

@Entity
@Data
@ToString
public class Member {

    @Id
    @Column(name ="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String password;

    private String address;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto dto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setAddress(dto.getName());
        member.setName(dto.getName());
        String password = passwordEncoder.encode(dto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }
}
