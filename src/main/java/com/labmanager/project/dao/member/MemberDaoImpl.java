package com.labmanager.project.dao.member;


import com.labmanager.project.entity.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberDaoImpl implements MemberDao {
    private EntityManager entityManager;

    @Autowired
    public MemberDaoImpl (EntityManager theEntityManager ){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member findById(int id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    @Transactional
    public String deleteMemberById(int id) {
        Member member = findById(id);
        if(member != null){
            entityManager.remove(member);
            return "Deleted Member";
        }

        return "Can't Delete Member";

    }

    @Override
    @Transactional
    public Member updateMemberById(Member memberUpdate, int id) {
        Member member = findById(id);
        if(member == null) {
            entityManager.persist(memberUpdate);
            return null;
        }

        member.setAllFeatureMember(memberUpdate);

        entityManager.merge(member);
         return  member;
    }


    @Override
    public List<Member> findByName(String name) {
        TypedQuery<Member> query = entityManager.createQuery("FROM Member WHERE Member.name like :name", Member.class);

        query.setParameter("name", "%" + name + "%");

        return query.getResultList();

    }

    @Override
    public List<Member> findAll() {
        TypedQuery<Member> query = entityManager.createQuery("FROM Member ", Member.class);

        return query.getResultList();
    }


}
