package com.pisi.marketplace.business.service;

import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.resource.model.MemberResource;

import org.springframework.stereotype.Component;

@Component
public class MemberConversor {
    public Member conversor(MemberResource memberResource) throws Exception {
        try {
            Member member = new Member();
            member.setUsername(memberResource.getUsername());
            member.setPassword(memberResource.getPassword());
            member.setFullName(memberResource.getFullName());
            member.setPhoneNumber(memberResource.getPhoneNumber());
            member.setEmail(memberResource.getEmail());
            member.setBirthday(memberResource.getBirthday());
            member.setAddress(memberResource.getAddress());
            return member;
        } catch (Exception e) {
            throw new Exception("erro: " + memberResource);
        }
    }
}
