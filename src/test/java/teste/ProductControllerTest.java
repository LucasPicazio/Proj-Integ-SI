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
import com.pisi.marketplace.resource.model.ProductResource;

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
	
	@Test
	public void salvarProduct() throws Exception{
		ProductResource product = new ProductResource();
		controller.salvarProduct(product);
	    
	 
	}

	@Test
	public void buscarProdutosPorBuscar() throws Exception{
		String txtBuscar = "cartola";
		List<Product> produto = controller.buscarProdutosPorBuscar(txtBuscar);
		Mockito.when(serviceBuscaProduct.buscarProdutosPorNome(txtBuscar)).thenReturn(produto);
		System.out.println(produto);
		//Assert.assertEquals(produto.contains(txtBuscar), true);
	}
	
}
