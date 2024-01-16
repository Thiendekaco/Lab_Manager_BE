package com.labmanager.project.dao.member;

import com.labmanager.project.entity.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDao {

    void save(Member member);

    Member findById(int id );

    String deleteMemberById( int id );

    Member updateMemberById (Member member, int id );


    List<Member> findByName (String name );

    List<Member> findAll ();

}
