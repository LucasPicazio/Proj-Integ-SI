
package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.repository.CartRepository;
import com.pisi.marketplace.resource.model.CartResource;

@Service
public class CartService {
    private static final Logger LOG = Logger.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    public int insertCart(CartResource cartResource) {
        try {System.out.println(cartResource);
        	Cart cart = conversor(cartResource);
            cartRepository.saveAndFlush(cart);
            return (int) cart.getCartId();
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
            return -1;
        }
    }

    public boolean removeCart(long id) {
        try {
        	System.out.println(id);
            cartRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar: " + e.getMessage(), e);
            return false;
        }
    }
    
    public Optional<Cart> findCartsById(long id) {
    	Optional<Cart> cartFoundById = cartRepository.findById(id);
    	return cartFoundById;
    }
    
    public Cart conversor(CartResource cartResource) throws Exception {
        try {
            Cart cart = new Cart();
            cart.setMemberId(cartResource.getMemberID());
            cart.setProductId(cartResource.getProductID());
            cart.setQuantity(cartResource.getQuantity());
            return cart;
        } catch (Exception e) {
            throw new Exception("erro: " + cartResource);
        }
    }

}