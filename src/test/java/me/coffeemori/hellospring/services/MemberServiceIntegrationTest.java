package me.coffeemori.hellospring.services;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import me.coffeemori.hellospring.domains.Member;
import me.coffeemori.hellospring.repositories.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

  @Autowired MemberService memberService;
  @Autowired MemberRepository memberRepository;

  @Test
  void join() {
    // given
    Member member = new Member();
    member.setName("spring");

    // when
    Long savedId = memberService.join(member);

    // then
    Member findedMember = memberService.findOne(savedId).get();
    assertThat(member.getName()).isEqualTo(findedMember.getName());
  }

  @Test
  void duplicateJoinException() {
    // given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    // when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      memberService.join(member2);
    });
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    // then
  }

  @Test
  void findMembers() {

  }

  @Test
  void findOne() {

  }
  
}
