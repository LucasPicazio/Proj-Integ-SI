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

import com.pisi.marketplace.business.service.MemberService;
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
		Member member = new Member();
		member.setMemberId(5);
		member.setUsername("username");
		member.setPassword("pass");

		Mockito.when(repository.saveAndFlush((Member) Mockito.any())).thenReturn(member);

		int iDsaved = service.registerMember(new MemberResource("username", "true", "pass", "lala@lala.com", "fullname",
				"9999-9999", "rua endereco", "21/04/1990"));
		Assert.assertEquals(iDsaved, member.getMemberId());
	}

	@Test
	public void loginMember() throws Exception {
		Member member = new Member();
		member.setUsername("username");
		member.setPassword("pass");
		Optional<Member> memberOpt = Optional.of(member);
	
		Mockito.when(repository.findMemberByUsername((String) Mockito.any())).thenReturn(memberOpt);
		
		MemberResource memberResource = new MemberResource("username", "true", "pass", "lala@lala.com", "fullname",
				"9999-9999", "rua endereco", "21/04/1990");
		int iDlogged = service.loginMember(memberResource);

		Assert.assertNotEquals(-1, iDlogged);
	}
	
	@Test
	public void loginMemberNotFound() throws Exception {
		MemberResource memberNotRegistered = new MemberResource("username", "true", "pass", "lala@lala.com", "fullname",
				"9999-9999", "rua endereco", "21/04/1990");

		int memberId = service.loginMember(memberNotRegistered);
		
		Assert.assertEquals(-1, memberId);
	}
	
}
