package com.labmanager.project.rest.member;


import com.labmanager.project.entity.member.Member;
import com.labmanager.project.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberRestController {

    private MemberService memberService;

    @Autowired
    public MemberRestController(MemberService theMemberService) {
        memberService = theMemberService;
    }


    @GetMapping("/members")
    public List<Member> findAll() {
        return memberService.findAll();
    }


    @GetMapping("/members/{memberId}")
    public Member getMemberById(@PathVariable int memberId){
        Member member = memberService.findById(memberId);

        if(member == null){
            throw new RuntimeException("Employee id not found - " + memberId);
        }

        return member;
    }

    @DeleteMapping("/members/{memberId}")
    public String deleteMember(@PathVariable int memberId){
        return memberService.deleteById(memberId);
    }





    @PutMapping("/members/{memberId}")
    public Member updateEmployee(@PathVariable int memberId, @RequestBody Member theMemberUpdate) {
        System.out.println(memberId + " " + theMemberUpdate);

        return memberService.updateMemberById(theMemberUpdate, memberId);
    }


    @DeleteMapping("/member/{memberId}")
    public String deleteEmployee(@PathVariable int memberId) {

        Member tempMember = memberService.findById(memberId);

        // throw exception if null

        if (tempMember == null) {
            throw new RuntimeException("Employee id not found - " + memberId);
        }

        memberService.deleteById(memberId);

        return "Deleted employee id - " + memberId;
    }


}
