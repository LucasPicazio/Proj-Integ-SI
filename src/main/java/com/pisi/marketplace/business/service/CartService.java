
package com.pisi.marketplace.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.repository.CartRepository;
import com.pisi.marketplace.resource.model.CartResource;

@Service
public class CartService {
	private static final Logger LOG = Logger.getLogger(CartService.class);

	@Autowired
	private CartRepository cartRepository;

	public int insertCart(CartResource cartResource) {
		try {
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
	
	public List<Cart> findCartsByMemberId(long id){
		List<Cart> cartList = cartRepository.findAll();
		ArrayList<Cart> cartResult = new ArrayList<Cart>();// para armazenar resultados
		for (Cart cart : cartList) {
			Member descriptionCart = cart.getMemberId();
			if (descriptionCart.getMemberId() == id) {
				cartResult.add(cart);
			}
		}
		return cartResult;
	}

	public void removeCartsByMemberId(long id){
		List<Cart> cartList = findCartsByMemberId(id);
		int i;
		for(i=0;i<cartList.size();i++) {
			removeCart(cartList.get(i).getCartId());
		}
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
