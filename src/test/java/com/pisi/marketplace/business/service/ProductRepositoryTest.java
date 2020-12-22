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
		Product produto = new Product();
		produto.setProductId(0);
		produto.setProductName("xpto");
		
		Mockito.when(repository.saveAndFlush((Product)Mockito.any())).thenReturn(produto);
		
		int salvo = service.registerProduct(new ProductResource());
		Assert.assertEquals(salvo, produto.getProductId());
	}
	
	@Test
	public void findAllProducts() {
		List<Product> produto = new ArrayList<Product>();
		
		Mockito.when(repository.findAll()).thenReturn(produto);
		
		List<Product> tdsProdutos = service.findAllProducts();
		Assert.assertEquals(tdsProdutos, produto);
	}
	
	@Test
	public void findAllProductsByName() {
		String textoASerBuscado = "xpto";
		List<Product> produto = new ArrayList<Product>();
		List<Product> produtosAchados = new ArrayList<Product>();
		
		Mockito.when(repository.findAll()).thenReturn(produto);
		int i;
		for(i=0;i<produto.size();i++) {
			if(produto.get(i).getProductName().contains(textoASerBuscado)) {
				produtosAchados.add(produto.get(i));
			}
		}
		
		List<Product> tdsProdutosAchados = service.findAllProductsByName(textoASerBuscado);
		Assert.assertEquals(tdsProdutosAchados, produtosAchados);
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


