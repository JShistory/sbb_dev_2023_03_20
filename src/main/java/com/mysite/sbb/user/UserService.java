package com.mysite.sbb.user;

import com.mysite.sbb.SecurityConfig;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;
    public SiteUser create(String username,  String email, String password){
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        //spring security에서 지원하는 암호 해쉬 알고리즘
        //스프링 시큐리티(Spring Seurity) 프레임워크에서 제공하는 클래스 중 하나로
        // 비밀번호를 암호화하는 데 사용할 수 있는 메서드를 가진 클래스입니다.
        // 비밀번호를 암호화 함으로 써 비밀번호 데이터가 노출되더라도 확인하기 어렵도록 만들어 줌.
        user.setPassword(passwordEncoder.encode(password));
        this.siteUserRepository.save(user);
        return user;
    }
}
