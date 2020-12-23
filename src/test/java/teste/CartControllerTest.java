package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pisi.marketplace.business.service.CartService;
import com.pisi.marketplace.controller.CartController;
import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.resource.model.CartResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CartController.class)
public class CartControllerTest {
	@MockBean
    private CartService service;
	
	@Autowired
	private CartController controller;
	
	@Test
	public void insertCart() throws Exception {
		CartResource cart = new CartResource();
		Mockito.when(service.insertCart(cart)).thenReturn(1);
		int result = controller.insertCart(cart);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void findCartsById() throws Exception {
		long idToFind = 1;
		Optional<Cart> cartToReturn = Optional.empty();
		Mockito.when(service.findCartsById(idToFind)).thenReturn(cartToReturn);
		Optional<Cart> cartReturned = controller.findCartsById(idToFind);
		Assert.assertEquals(cartToReturn, cartReturned);
	}
	
	@Test
	public void findCartsByMemberId() throws Exception {
		List<Cart> cartsToReturn = new ArrayList<Cart>();
		int memberIdToFind = 1;
		Mockito.when(service.findCartsByMemberId(memberIdToFind)).thenReturn(cartsToReturn);
		List<Cart> cartsReturned = controller.findCartsByMemberId(memberIdToFind);
		Assert.assertEquals(cartsToReturn, cartsReturned);
	}
	
	@Test
	public void removeCartsById() throws Exception {
		boolean removed = true;
		int id = 1;
		Mockito.when(service.removeCart(id)).thenReturn(removed);
		boolean cartsRemoved = controller.removeCartsById(id);
		Assert.assertEquals(removed, cartsRemoved);
	}
	
	@Test
	public void removeCartsByMemberId() throws Exception {
		boolean removed = true;
		long memberIdToFind = 1;
		Mockito.when(service.removeCartsByMemberId(memberIdToFind)).thenReturn(removed);
		boolean cartsRemoved = controller.removeCartsByMemberId(memberIdToFind);
		Assert.assertEquals(removed, cartsRemoved);
	}
}
