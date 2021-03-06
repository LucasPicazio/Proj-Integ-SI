package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.repository.ProductRepository;
import com.pisi.marketplace.resource.model.ProductResource;

@Service
public class ProductService {
	private static final Logger LOG = Logger.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	public int registerProduct(ProductResource productResource) {
		try {
			Product product = conversor(productResource);
			var res = productRepository.saveAndFlush(product);
			return (int) res.getProductId();
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
			return -1;
		}
	}

	public List<Product> findAllProducts() {
		List<Product> listProducts = productRepository.findAll();
		return listProducts;
	}

	public List<Product> findAllProductsByName(String toFind) {
		List<Product> productList = productRepository.findAll();
		ArrayList<Product> productsResult = new ArrayList<Product>();// para armazenar resultados
		for (Product product : productList) {
			String descriptionProd = product.getDescription().toUpperCase();
			String nameProd = product.getProductName().toUpperCase();
			String typeProd = product.getProductType().toUpperCase();
			if (descriptionProd.contains(toFind.toUpperCase()) || nameProd.contains(toFind.toUpperCase())
					|| typeProd.contains(toFind.toUpperCase())) {
				productsResult.add(product);
			}
		}
		return productsResult;
	}

	public Optional<Product> findProductsById(long id) {
		Optional<Product> productFoundById = productRepository.findById(id);
		return productFoundById;
	}

	public Product conversor(ProductResource productResource) throws Exception {
		try {
			Product product = new Product();
			product.setDescription(productResource.getDescription());
			product.setImageSource(productResource.getImageSource());
			product.setPrice(productResource.getPrice());
			product.setProductName(productResource.getProductName());
			product.setProductType(productResource.getProductType());
			product.setStock(productResource.getStock());
			return product;
		} catch (Exception e) {
			throw new Exception("erro: " + productResource);
		}
	}

}
