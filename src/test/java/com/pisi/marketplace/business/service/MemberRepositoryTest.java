package com.pisi.marketplace.business.service;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.repository.MemberRepository;
import com.pisi.marketplace.resource.model.MemberResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MemberRepositoryTest {
	@MockBean
	private MemberRepository repository;
	
	@Autowired
	private MemberService service;
	
	@Test
	public void registerMember() {
		Member membro = new Member();
		membro.setMemberId(0);
		membro.setUsername("username");
		
		Mockito.when(repository.save((Member)Mockito.any())).thenReturn(membro);
		
		int salvo = service.registerMember(new MemberResource("username","true","pass","lala@lala.com","fullname","9999-9999","rua endereco","21/04/1990"));
		Assert.assertEquals(salvo, membro.getMemberId());
	}
	
	@Test
	public void loginMemberNotFound() {
		try {Member member = service.conversor(new MemberResource("username","true","pass","lala@lala.com","fullname","9999-9999","rua endereco","21/04/1990"));	
		Optional<Member> membro = Optional.empty();
		Mockito.when(repository.findMemberByUsername(member.getUsername())).thenReturn(membro);
		
		int salvo = service.loginMember(new MemberResource("username","true","pass","lala@lala.com","fullname","9999-9999","rua endereco","21/04/1990"));
		}catch(Exception e) {
			
		}
		
	}

}
