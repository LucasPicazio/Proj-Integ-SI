package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.repository.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;// to work, it need this dependencies

	@Autowired
	public MemberService( MemberRepository memberRepository ) {
		this.memberRepository = memberRepository;
	}

	public List<Member> getAllMembers() {
		
		Iterable<Member> members = this.memberRepository.findAll();
		List<Member> listMembers= new ArrayList<>();
		members.forEach(listMembers::add);
		return listMembers;
		
	}
	
}
