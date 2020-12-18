package me.coffeemori.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.coffeemori.hellospring.repositories.MemberRepository;
import me.coffeemori.hellospring.repositories.MemoryMemberRepository;
import me.coffeemori.hellospring.services.MemberService;

@Configuration
public class SpringConfig {
  
  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
  
}
