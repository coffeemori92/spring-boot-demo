package me.coffeemori.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.coffeemori.hellospring.repositories.JdbcMemberRepository;
import me.coffeemori.hellospring.repositories.MemberRepository;
import me.coffeemori.hellospring.repositories.MemoryMemberRepository;
import me.coffeemori.hellospring.services.MemberService;

@Configuration
public class SpringConfig {
  
  private DataSource dataSource;

  @Autowired
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//    return new JdbcMemberRepository(dataSource);
    return new JdbcMemberRepository(dataSource);
  }

}
