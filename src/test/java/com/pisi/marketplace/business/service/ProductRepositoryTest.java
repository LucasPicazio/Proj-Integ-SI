package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.business.service.ProductService;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.repository.ProductRepository;
import com.pisi.marketplace.resource.model.ProductResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductRepositoryTest {
	@MockBean
	private ProductRepository repository;

	@Autowired
	private ProductService service;

	@Test
	public void registerProduct() {
		Product product = new Product();
		product.setProductId(5);
		product.setProductName("shoes");

		Mockito.when(repository.saveAndFlush((Product) Mockito.any())).thenReturn(product);

		int idSaved = service.registerProduct(new ProductResource());
		Assert.assertEquals(idSaved, product.getProductId());
	}

	@Test
	public void findAllProducts() {
		Product product1 = new Product();
		product1.setProductName("shoes");
		
		Product product2 = new Product();
		product2.setProductName("earrings");
		
		List<Product> productsInserted = new ArrayList<Product>();
		productsInserted.add(product1);
		productsInserted.add(product2);

		Mockito.when(repository.findAll()).thenReturn(productsInserted);

		List<Product> productsToFind = service.findAllProducts();
		productsToFind.add(product2);
		productsToFind.add(product1);
		
		Assert.assertEquals(productsToFind.size(), productsInserted.size());
	}

	@Test
	public void findAllProductsByName() {
		Product product1 = new Product();
		product1.setProductName("shoes");
		product1.setDescription("pair of shoes");
		product1.setProductType("clothes");
		
		Product product2 = new Product();
		product2.setProductName("earrings");
		product2.setDescription("pair of earrings");
		product2.setProductType("beauty");
		
		String txtToFind = "shoes";
		
		List<Product> productsInserted = new ArrayList<Product>();
		productsInserted.add(product1);
		productsInserted.add(product2);
		
		List<Product> productsToFind = new ArrayList<Product>();

		Mockito.when(repository.findAll()).thenReturn(productsInserted);
		
		int i;
		for (i = 0; i < productsInserted.size(); i++) {
			if (productsInserted.get(i).getProductName().contains(txtToFind)) {
				productsToFind.add(productsInserted.get(i));
			}
		}

		List<Product> productsFinded = service.findAllProductsByName(txtToFind);
		
		Assert.assertEquals(productsFinded.get(0).getProductName(), productsToFind.get(0).getProductName());
	}

	@Test
	public void findProductsById() {
		Optional<Product> produto = Optional.empty();
		long id = 0;

		Mockito.when(repository.findById(id)).thenReturn(produto);

		Optional<Product> produtoPorID = service.findProductsById(id);
		Assert.assertEquals(produtoPorID, produto);
	}
}
