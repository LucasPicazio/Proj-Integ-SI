package teste;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.business.service.BuscaProductServiceImpl;
import com.pisi.marketplace.business.service.CadastroProductServiceImpl;
import com.pisi.marketplace.controller.ProductController;
import com.pisi.marketplace.data.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ProductController.class)
public class ProductControllerTest  {

	@MockBean
	private CadastroProductServiceImpl serviceCadastroProduct;
    
	@MockBean
	private BuscaProductServiceImpl serviceBuscaProduct;
	
	@Autowired
	private ProductController controller;
	
	
	@Test
	public void buscarProdutos() throws Exception{
		List<Product> listaProdutos = controller.buscarProdutos();
		Mockito.when(serviceBuscaProduct.buscarTodosOsProdutos()).thenReturn(listaProdutos);
		Assert.assertNotNull(listaProdutos);
		}
	
//	@Test
//	public void buscarProdutosPorBuscar() throws Exception{
//		
//	}
	
//	@Test
//	public void logarMember() throws Exception {
//		ResponseEntity entity = ResponseEntity.status(200).build();
//		
//		Mockito.when(serviceLoginMember.loginMember((MemberResource)Mockito.any())).thenReturn(entity);
//		
//		ResponseEntity retorno = controller.logarMember(new MemberResource("meuusuario", "minhasenha", "meuemail@gmail.com", "Meu Nome Completo", "(11)98765-4321", "Rua Endereco, 1", "01/02/1998"));
//		//System.out.println(retorno.getStatusCodeValue()+" "+entity);
//		Assert.assertEquals(entity, retorno);
//		Assert.assertEquals(200, retorno.getStatusCodeValue());
//	}
//	
//	@Test
//	public void salvarMember() throws Exception{
//		MemberResource member = new MemberResource("meuusuario", "minhasenha", "meuemail@gmail.com", "Meu Nome Completo", "(11)98765-4321", "Rua Endereco, 1", "01/02/1998");
//		System.out.println();
//		
//		Mockito.when(serviceCadastroMember.cadastroMember(member)).thenReturn(true);
//		boolean retorno = controller.salvarMember(member);
//		Assert.assertEquals(true, retorno);
//	}
}
