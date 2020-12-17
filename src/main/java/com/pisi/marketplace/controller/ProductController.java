package com.pisi.marketplace.controller;

import java.util.List;
import java.util.Optional;

//import com.pisi.marketplace.business.service.BuscaProductServiceImpl;
//import com.pisi.marketplace.business.service.CadastroProductServiceImpl;
import com.pisi.marketplace.business.service.ProductService;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.exception.NotFoundException;
import com.pisi.marketplace.resource.model.ProductResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("search")
	public List<Product> searchProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("search/{search}")
	public List<Product> findProductsBySearch(@PathVariable(name = "search", required = true) String search)
			throws NotFoundException {
		return productService.findAllProductsByName(search);
	}

	@GetMapping("search/id/{searchID}")
	public Optional<Product> findProductsById(@PathVariable(name = "searchID", required = true) long searchID)
			throws NotFoundException {
		return productService.findProductsById(searchID);
	}

	@PostMapping("save")
	public int registerProduct(@RequestBody ProductResource product) {
		return productService.registerProduct(product);
	}
}
