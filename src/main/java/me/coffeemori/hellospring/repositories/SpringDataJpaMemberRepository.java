package me.coffeemori.hellospring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.coffeemori.hellospring.domains.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
  Optional<Member> findByName(String name);
}
