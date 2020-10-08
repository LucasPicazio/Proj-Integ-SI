package com.pisi.marketplace.business.service;

import com.pisi.marketplace.data.entity.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import com.pisi.marketplace.data.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> buscarTodosOsProdutos() {
        List<Product> listProdutos = productRepository.findAll();
        return listProdutos;
    }

    public List<Product> buscarProdutosPorNome(String buscar) {
        List<Product> listProdutos = productRepository.findAll();
        ArrayList<Product> resultadoProdutos = new ArrayList<Product>();// para armazenar resultados
        for (Product produto : listProdutos) {
            String descricaoProd = produto.getDescription().toUpperCase();
            String nomeProd = produto.getProductName().toUpperCase();
            String tipoProd = produto.getProductType().toUpperCase();
            if (descricaoProd.contains(buscar.toUpperCase()) || nomeProd.contains(buscar.toUpperCase())
                    || tipoProd.contains(buscar.toUpperCase())) {
                resultadoProdutos.add(produto);
            }
        }

        return resultadoProdutos;
    }
}
