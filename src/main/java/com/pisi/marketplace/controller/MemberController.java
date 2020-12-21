package com.pisi.marketplace.controller;

import com.pisi.marketplace.business.service.MemberService;
//import com.pisi.marketplace.business.service.MemberAccountService;
import com.pisi.marketplace.resource.model.MemberResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("register")
    public int registerMember(@RequestBody MemberResource member) {
        return memberService.registerMember(member);
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping("login")
    public int loginMember(@RequestBody MemberResource member) throws Exception {
    	return memberService.loginMember(member);
    }

}
