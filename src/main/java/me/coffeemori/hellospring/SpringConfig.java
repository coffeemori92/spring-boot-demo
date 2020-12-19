package me.coffeemori.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.coffeemori.hellospring.repositories.JdbcMemberRepository;
import me.coffeemori.hellospring.repositories.JpaMemberRepository;
import me.coffeemori.hellospring.repositories.MemberRepository;
import me.coffeemori.hellospring.repositories.MemoryMemberRepository;
import me.coffeemori.hellospring.services.MemberService;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  // private EntityManager em;

  // @Autowired
  // public SpringConfig(EntityManager em) {
  //   this.em = em;
  // }
  
  // private DataSource dataSource;

  // @Autowired
  // public SpringConfig(DataSource dataSource) {
  //   this.dataSource = dataSource;
  // }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
//    return new MemberService(memberRepository());
  }

//   @Bean
//   public MemberRepository memberRepository() {
// //    return new MemoryMemberRepository();
// //    return new JdbcMemberRepository(dataSource);
// //    return new JdbcMemberRepository(dataSource);
//     return new JpaMemberRepository(em);
//   }

}
