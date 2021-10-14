package hello.hello_spring.controller;

import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
/*
스프링 부트가 실행될 때 스프링 컨테이너가 생성되고 @Controller이 있는(스프링과 관련된, 정확히는 @Component가 있는) 겍체(스프링 빈)는
컨테이너에 등록이 된다(컴포넌트 스캔 == 자동 의존관계 설정). 등록이 된 겍체는 하나만 등록해서 공유한다.(같은 스프링 빈이면 모두 같은 인스턴스다)
*/
public class MemberController {
    private final MemberService memberService;

    @Autowired
/*
    @Autowired(생성자, setter, 필드 에서 이용 가능)를 이용하면 스프링 빈 간의 연관관계를 설정(연결)해준다[의존성 주입]
*/
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
