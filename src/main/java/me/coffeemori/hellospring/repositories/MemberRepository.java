package me.coffeemori.hellospring.repositories;

import java.util.List;
import java.util.Optional;

import me.coffeemori.hellospring.domains.Member;

public interface MemberRepository {
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
