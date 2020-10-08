package com.pisi.marketplace.business.service;

import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.repository.ProductRepository;
import com.pisi.marketplace.resource.model.ProductResource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProductServiceImpl {
    private static final Logger LOG = Logger.getLogger(CadastroProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConversor productConversor;

    public void cadastroProduct(ProductResource productResource) {
        try {
            Product product = productConversor.conversor(productResource);
            productRepository.saveAndFlush(product);
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
        }
    }
}
