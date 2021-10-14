package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //ctrl+shift+t 를 이용해 테스트파일을 바로 만들 수 있다.
    //final이 붙은 변수,메서드는 한 번 선언(초기화) 이후 변경할 수 없음
    // 이거 이해 안감 ?? 인터페이스인데 이렇게 클래스처럼 써도 되나?
    // 해결 >>    나중에 DB랑 연동할때 쓰려고 이름이 다른거고
    //    지금은 MemoryMemberRepository를 쓰지만 나중엔 다른 걸 쓸꺼임
    //    그리고 당연히 여기서 쓰는 memberRepository는 클래스임(인터페이스X)
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        // 이름 중복X
        validateDuplicateMember(member); //중복 검사
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
