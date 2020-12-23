package teste;

import java.util.ArrayList;
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
@SpringBootTest(classes = ProductController.class)
public class ProductControllerTest {

	@MockBean
	private ProductService productService;

	@Autowired
	private ProductController controller;

	@Test
	public void findProducts() throws Exception {
		List<Product> productListToReturn = new ArrayList<Product>();
		Mockito.when(productService.findAllProducts()).thenReturn(productListToReturn);
		List<Product> productListReturned = controller.searchProducts();
		Assert.assertNotNull(productListReturned);
	}

	@Test
	public void registerProduct() throws Exception {
		ProductResource product = new ProductResource();
		Mockito.when(productService.registerProduct(product)).thenReturn(1);
		int result = controller.registerProduct(product);
		Assert.assertEquals(1, result);
	}

	@Test
	public void findProductsBySearch() throws Exception {
		List<Product> productsToReturn = new ArrayList<Product>();
		String toFind = "shoes";
		Mockito.when(productService.findAllProductsByName(toFind)).thenReturn(productsToReturn);
		List<Product> productsReturned = controller.findProductsBySearch(toFind);
		Assert.assertEquals(productsToReturn, productsReturned);
	}

	@Test
	public void findProductsById() throws Exception {
		long idToFind = 1;
		Optional<Product> productToReturn = Optional.empty();
		Mockito.when(productService.findProductsById(idToFind)).thenReturn(productToReturn);
		Optional<Product> productReturned = controller.findProductsById(idToFind);
		Assert.assertEquals(productToReturn, productReturned);
	}
}
