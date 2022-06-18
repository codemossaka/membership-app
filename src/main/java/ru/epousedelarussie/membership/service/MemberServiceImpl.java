package ru.epousedelarussie.membership.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.epousedelarussie.membership.entity.Member;
import ru.epousedelarussie.membership.exception.MemberNotFoundException;
import ru.epousedelarussie.membership.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMemberByFirstName(String firstName) {
        return memberRepository.findAllByFirstName(firstName);
    }

    @Override
    public Member getMember(long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Il n'existe pas de membre avec id =" + id));
    }

    @Override
    public List<Member> getMembersList() {
        return memberRepository.findAll();
    }

    @Override
    public String removeMember(long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isPresent()) {
            memberRepository.delete(member.get());
            return "Membre supprime avec succes";
        } else {
            return "Il n'existe pas de membre avec id =" + id;
        }
    }

    @Override
    public Member updateMember(long id, Member memberIn) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            member.get().setFirstName(memberIn.getFirstName());
            member.get().setLastName(memberIn.getLastName());
            member.get().setBirthDate(memberIn.getBirthDate());
            member.get().setSex(memberIn.getSex());
            member.get().setPhone(memberIn.getPhone());
            return memberRepository.save(member.get());
        } else {
            throw new MemberNotFoundException("Il n'existe pas de membre avec id =" + id);
        }
    }
}
