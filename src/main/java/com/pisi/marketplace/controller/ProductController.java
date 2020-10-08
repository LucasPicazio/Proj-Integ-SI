package com.pisi.marketplace.controller;

import java.util.List;

import com.pisi.marketplace.business.service.BuscaProductServiceImpl;
import com.pisi.marketplace.business.service.CadastroProductServiceImpl;
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
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private BuscaProductServiceImpl serviceBuscaProduct;

    @Autowired
    private CadastroProductServiceImpl serviceCadastroProduct;

    @GetMapping(path = "/search")
    public List<Product> buscarProdutos() {
        return serviceBuscaProduct.buscarTodosOsProdutos();
    }

    @GetMapping(path = "/search/{buscar}")
    public List<Product> buscarProdutosPorBuscar(@PathVariable(name = "buscar", required = true) String buscar)
            throws NotFoundException {
        return serviceBuscaProduct.buscarProdutosPorNome(buscar);
    }

    @PostMapping(path = "/save")
    public void salvarProduct(@RequestBody ProductResource product) {
        serviceCadastroProduct.cadastroProduct(product);
    }
}
