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

import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.data.entity.repository.CartRepository;
import com.pisi.marketplace.resource.model.CartResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CartRepositoryTest {
	@MockBean
	private CartRepository repository;

	@Autowired
	private CartService service;
	
	
	
	
	@Test
	public void insertCart() {
		Cart cart = new Cart();
		Mockito.when(repository.saveAndFlush((Cart) Mockito.any())).thenReturn(cart);

		int iDsaved = service.insertCart(new CartResource());
		Assert.assertEquals(iDsaved, cart.getCartId());
	}
	
//	@Test
//	public void insertCartException() {
//		Cart cart = new Cart();
//
//		Mockito.when(repository.saveAndFlush((Cart) Mockito.any())).thenReturn(cart);
//		System.out.println(cart.getCartId());
//		Assert.assertEquals(-1, cart.getCartId());
//	}
	
	@Test
	public void removeCart() {
		Cart cart = new Cart();
		cart.setCartId(1);
		repository.deleteById(cart.getCartId());
		Optional <Cart> teste = repository.findById(cart.getCartId());
		Optional<Cart> vazio = Optional.empty();
		boolean testeBool;
		if(teste == vazio)testeBool = true;
		else testeBool=false;
		
		boolean removeu = service.removeCart(cart.getCartId());
				
		Assert.assertEquals(testeBool,removeu);
		//Mockito.verify(repository, Mockito.times(1)).deleteById(cart.getCartId());
	}
	
	@Test
	public void removeCartsByMemberId() {
		long memberID = 0;
		Member member = new Member();
		member.setMemberId(memberID);
		Cart cart1 = new Cart();
		cart1.setMemberId(member);
		Cart cart2 = new Cart();
		cart2.setMemberId(member);
		
		List<Cart> cartsInserted = new ArrayList<Cart>();
		cartsInserted.add(cart1);
		cartsInserted.add(cart2);
		
		List<Cart> cartsRemoved = new ArrayList<Cart>();

		Mockito.when(repository.findAll()).thenReturn(cartsInserted);
		
		int i;
		for (i = 0; i < cartsInserted.size(); i++) {
			Member descriptionCart = cartsInserted.get(i).getMemberId();
			if (descriptionCart.getMemberId()==memberID) {
				cartsRemoved.add(cartsInserted.get(i));
				repository.deleteById(cartsInserted.get(i).getCartId());
			}
		}
		boolean removeu;
		if(cartsRemoved.size()>0) removeu = true;
		else removeu = false;
		boolean retorno = service.removeCartsByMemberId(memberID);
		
		Assert.assertEquals(removeu, retorno);
		
	}
	
	@Test
	public void findCartsById() {
		long id = 0;
		
		Optional<Cart> cart = Optional.empty();
		Mockito.when(repository.findById(id)).thenReturn(cart);

		Optional<Cart> cartServ = service.findCartsById(id);
		Assert.assertEquals(cartServ, cart);
	}
	
	@Test
	public void findCartsByMemberId() {
		long memberId = 0;
		List<Cart> carts = new ArrayList<Cart>();
		List<Cart> resultado = new ArrayList<Cart>();
		Mockito.when(repository.findAll()).thenReturn(carts);
		for(Cart cart : carts) {
			Member descriptionCart = cart.getMemberId();
			if(descriptionCart.getMemberId()==0)resultado.add(cart);
		}
		List<Cart> cartServ = service.findCartsByMemberId(memberId);
		Assert.assertEquals(resultado, cartServ);
	}
}
