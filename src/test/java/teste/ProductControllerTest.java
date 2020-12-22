package teste;


import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

//import com.pisi.marketplace.business.service.BuscaProductServiceImpl;
//import com.pisi.marketplace.business.service.CadastroProductServiceImpl;
import com.pisi.marketplace.business.service.ProductService;
import com.pisi.marketplace.controller.ProductController;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.resource.model.ProductResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ProductController.class)
public class ProductControllerTest  {

	@MockBean
	private ProductService productService;
	
	@Autowired
	private ProductController controller;
	
	
	@Test
	public void findProducts() throws Exception{
		List<Product> productList = controller.searchProducts();
		Mockito.when(productService.findAllProducts()).thenReturn(productList);
		Assert.assertNotNull(productList);
		}
	
	@Test
	public void registerProduct() throws Exception{
		ProductResource product = new ProductResource();
		controller.registerProduct(product);
	    
	 
	}

	@Test
	public void findProductsBySearch() throws Exception{
		String toFind = "cartola";
		List<Product> product = controller.findProductsBySearch(toFind);
		Mockito.when(productService.findAllProductsByName(toFind)).thenReturn(product);
		System.out.println(product);
		//Assert.assertEquals(produto.contains(txtBuscar), true);
	}
	
	@Test
	public void findProductsById() throws Exception{
		long idToFind = 1;
		Optional<Product> product = controller.findProductsById(idToFind);
		Assert.assertFalse(product.isPresent());//errad
	}
}
