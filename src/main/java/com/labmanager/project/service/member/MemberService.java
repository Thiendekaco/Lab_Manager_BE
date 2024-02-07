package com.labmanager.project.service.member;

import com.labmanager.project.entity.member.Member;

import java.util.List;

public interface MemberService {

    List<Member> findByName( String name );

    Member findByEmail ( String email );

    Member findById(int theId);

    void save(Member theMember);

    String deleteById(int theId);

    Member updateMemberById ( Member member, int id );


    List<Member> findAll ();
}
