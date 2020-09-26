package com.pisi.marketplace.business.service;

import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.repository.MemberRepository;
import com.pisi.marketplace.resource.model.MemberResource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginMemberServiceImpl {
	
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConversor memberConversor;

    @SuppressWarnings("rawtypes")
	public ResponseEntity loginMember(MemberResource memberResource) throws Exception {
    	Member member = memberConversor.conversor(memberResource);	
        Optional<Member> optionalMember = memberRepository.findMemberByUsername(member.getUsername());
           
        if (optionalMember.isPresent() && optionalMember.get().getPassword().equals(member.getPassword())) {
        	return new ResponseEntity(HttpStatus.OK);
        } else {
        	return new ResponseEntity(HttpStatus.FORBIDDEN);
        }       
    }
}
