package me.coffeemori.hellospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import me.coffeemori.hellospring.services.MemberService;

@Controller
public class MemberController {
  
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

}
