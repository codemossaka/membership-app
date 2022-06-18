package ru.epousedelarussie.membership.service;

import ru.epousedelarussie.membership.entity.Member;

import java.util.List;

public interface MemberService {

    Member saveMember(Member member);

    List<Member> getMemberByFirstName(String firstName);

    Member getMember(long id);

    List<Member> getMembersList();

    String removeMember(long id);

    Member updateMember(long id, Member member);


}
