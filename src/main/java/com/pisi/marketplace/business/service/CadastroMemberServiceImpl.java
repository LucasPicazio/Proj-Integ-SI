package com.pisi.marketplace.business.service;

import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.repository.MemberRepository;
import com.pisi.marketplace.resource.model.MemberResource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroMemberServiceImpl {
    private static final Logger LOG = Logger.getLogger(CadastroMemberServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberConversor memberConversor;

    public boolean cadastroMember(MemberResource memberResource) {
        try {
            Member member = memberConversor.conversor(memberResource);
            memberRepository.saveAndFlush(member);
            return true;
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
            return false;
        }
    }
}
