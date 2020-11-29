package com.pisi.marketplace.controller;

import com.pisi.marketplace.business.service.CadastroMemberServiceImpl;
import com.pisi.marketplace.business.service.LoginMemberServiceImpl;
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
@RequestMapping(value = "/api/members")
public class MemberController {

    @Autowired
    private CadastroMemberServiceImpl serviceCadastroMember;
    
    @Autowired
    private LoginMemberServiceImpl serviceLoginMember;

    @PostMapping(path = "/save")
    public boolean salvarMember(@RequestBody MemberResource member) {
        return serviceCadastroMember.cadastroMember(member);
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping(path = "/login")
    public ResponseEntity logarMember(@RequestBody MemberResource member) throws Exception {
    	return serviceLoginMember.loginMember(member);
    }

}
