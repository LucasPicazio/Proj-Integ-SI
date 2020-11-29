package teste;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.business.service.CadastroMemberServiceImpl;
import com.pisi.marketplace.business.service.LoginMemberServiceImpl;
import com.pisi.marketplace.controller.MemberController;
import com.pisi.marketplace.resource.model.MemberResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MemberController.class)
public class MemberControllerTest  {

	@MockBean
    private CadastroMemberServiceImpl serviceCadastroMember;
    
	@MockBean
    private LoginMemberServiceImpl serviceLoginMember;
	
	@Autowired
	private MemberController controller;
	
	
	@Test
	public void logarMember() throws Exception {
		ResponseEntity entity = ResponseEntity.status(200).build();
		
		Mockito.when(serviceLoginMember.loginMember((MemberResource)Mockito.any())).thenReturn(entity);
		
		ResponseEntity retorno = controller.logarMember(new MemberResource("meuusuario", "minhasenha", "meuemail@gmail.com", "Meu Nome Completo", "(11)98765-4321", "Rua Endereco, 1", "01/02/1998"));
		//System.out.println(retorno.getStatusCodeValue()+" "+entity);
		Assert.assertEquals(entity, retorno);
		Assert.assertEquals(200, retorno.getStatusCodeValue());
	}
	
	@Test
	public void salvarMember() throws Exception{
		MemberResource member = new MemberResource("meuusuario", "minhasenha", "meuemail@gmail.com", "Meu Nome Completo", "(11)98765-4321", "Rua Endereco, 1", "01/02/1998");
		System.out.println();
		
		Mockito.when(serviceCadastroMember.cadastroMember(member)).thenReturn(true);
		boolean retorno = controller.salvarMember(member);
		Assert.assertTrue(retorno);
	}
}
