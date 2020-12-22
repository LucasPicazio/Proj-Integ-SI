package com.pisi.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pisi.marketplace.business.service.CartService;
import com.pisi.marketplace.data.entity.Cart;
import com.pisi.marketplace.exception.NotFoundException;
import com.pisi.marketplace.resource.model.CartResource;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("insert")
	public int insertCart(@RequestBody CartResource cart) {
		return cartService.insertCart(cart);
	}

	@GetMapping("search/id/{searchID}")
	public Optional<Cart> findCartsById(@PathVariable(name = "searchID", required = true) long searchID)
			throws NotFoundException {
		return cartService.findCartsById(searchID);
	}
	
	@GetMapping("search/member/{searchMemberID}")
	public List<Cart> findCartsByMemberId(@PathVariable(name = "searchMemberID", required = true) long searchMemberID)
			throws NotFoundException {
		return cartService.findCartsByMemberId(searchMemberID);
	}

	@PostMapping("{id}/remove")
	public boolean removeCartsById(@PathVariable(name = "id", required = true) long id) throws NotFoundException {
		return cartService.removeCart(id);
	}

	@PostMapping("member/{id}/remove")
	public void removeCartsByMemberId(@PathVariable(name = "id", required = true) long id) throws NotFoundException {
		cartService.removeCartsByMemberId(id);
	}
}
