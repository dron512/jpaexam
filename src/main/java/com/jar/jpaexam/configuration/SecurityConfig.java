package com.jar.jpaexam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

/*
    1. WebSecuriyConfiureAdapter를 상속받는 클래스에 @EnableWebSecurity 어노테이션을 선언하면 SpringSecurityFilterChain이
    자동으로 포함됩니다. WebSEcirotyCpnfiguareAdapter를 상속받아서 메소드 오버라이딩을 통해 보안설정을
    커스터 마이징 할 수 있습니다.
    2. http 요청에 대한 보안을 설정합니다.
    페이지 권한 설정, 로그인 페이지 설정, 로그아웃 메소드 등에 대한 설정을 작성합니다.
    뒤의 예제에서 설정 추가 방법을 알아보겠습니다.
    3. 비밀번호를 데이터베이스에 그대로 저장했을 경우, 데이터베이스가 해킹 당하면 고객의 회원 정보가 그대로 노출 됩니다.
    이를 해결하기 위해 BCrypPasswordEnconder의 해시 함수를 이용하여 비밀번호를 암호화여 저장 합니다.
 */