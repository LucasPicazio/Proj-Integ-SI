package com.pisi.marketplace.controller;

import com.pisi.marketplace.business.service.CadastroMemberServiceImpl;
import com.pisi.marketplace.resource.model.MemberResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/members")
public class MemberController {

    @Autowired
    private CadastroMemberServiceImpl serviceCadastroMember;

    @PostMapping(path = "/save")
    public void salvarMember(@RequestBody MemberResource member) {
        serviceCadastroMember.cadastroMember(member);
    }

}
