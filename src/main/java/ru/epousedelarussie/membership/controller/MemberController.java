package ru.epousedelarussie.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.epousedelarussie.membership.entity.Member;
import ru.epousedelarussie.membership.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> listMembers() {
        return memberService.getMembersList();
    }

    @GetMapping("/{id}")
    public Member findMember(@PathVariable  long id) {
        return memberService.getMember(id);
    }

    @GetMapping("/search/{firstName}")
    public List<Member> listMembersByFirstName(@PathVariable String firstName) {
        return memberService.getMemberByFirstName(firstName);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public Member changeMember(@RequestBody Member member, @PathVariable long id) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public String changeMember( @PathVariable long id) {
        return memberService.removeMember(id);
    }
}
