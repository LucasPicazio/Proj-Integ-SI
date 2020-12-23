package com.pisi.marketplace.business.service;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.repository.MemberRepository;
import com.pisi.marketplace.resource.model.MemberResource;

@Service
public class MemberService {
/*
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
*/
	private static final Logger LOG = Logger.getLogger(MemberService.class);
	
    @Autowired
    private MemberRepository memberRepository;

    public int registerMember(MemberResource memberResource) {
        try {
            Member member = conversor(memberResource);
            var res = memberRepository.saveAndFlush(member);
            return (int)res.getMemberId();
        } catch (Exception e) {
            LOG.error("Error to register: " + e.getMessage(), e);
            return -1;
        }
    }

    @SuppressWarnings("rawtypes")
	public int loginMember(MemberResource memberResource) throws Exception {
    	Member member = conversor(memberResource);	
        Optional<Member> optionalMember = memberRepository.findMemberByUsername(member.getUsername());

        if (optionalMember.isPresent() && optionalMember.get().getUsername().equals(member.getUsername()) && optionalMember.get().getPassword().equals(member.getPassword())) {
        	//return new ResponseEntity(HttpStatus.OK);
        	return (int) optionalMember.get().getMemberId();
        } else {
        	//return new ResponseEntity(HttpStatus.FORBIDDEN);
        	return -1;
        }       
    }
    
    public Member conversor(MemberResource memberResource) throws Exception {
        try {
            Member member = new Member();
            member.setUsername(memberResource.getUsername());
            member.setADMIN(memberResource.getAdmin());
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
