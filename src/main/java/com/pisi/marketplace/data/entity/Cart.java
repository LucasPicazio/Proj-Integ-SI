package com.pisi.marketplace.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;

	@ManyToOne
	@JoinColumn(name = "memberId")
	@ForeignKey(name = "fk_memberId_cart")
	private Member memberId;

	@ManyToOne
	@JoinColumn(name = "productId")
	@ForeignKey(name = "fk_productId_cart")
	private Product productId;

	private int quantity;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
