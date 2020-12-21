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

//import com.pisi.marketplace.business.service.MemberAccountService;
import com.pisi.marketplace.business.service.MemberService;
import com.pisi.marketplace.controller.MemberController;
import com.pisi.marketplace.resource.model.MemberResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MemberController.class)
public class MemberControllerTest  {

	@MockBean
    private MemberService memberService;
	
	@Autowired
	private MemberController controller;
	
	
	@Test
	public void loginMember() throws Exception {
		
		Mockito.when(memberService.loginMember((MemberResource)Mockito.any())).thenReturn(1);
		
		int retorno = controller.loginMember(new MemberResource("meuusuario", "0", "minhasenha", "meuemail@gmail.com", "Meu Nome Completo", "(11)98765-4321", "Rua Endereco, 1", "01/02/1998"));
		//System.out.println(retorno.getStatusCodeValue()+" "+entity);
		Assert.assertEquals(1, retorno);
	}
	
	@Test
	public void registerMember() throws Exception{
		MemberResource member = new MemberResource("meuusuario", "0","minhasenha", "meuemail@gmail.com", "Meu Nome Completo", "(11)98765-4321", "Rua Endereco, 1", "01/02/1998");
		
		Mockito.when(memberService.registerMember(member)).thenReturn(1);
		int retorno = controller.registerMember(member);
		Assert.assertEquals(1, retorno);
	}
}
