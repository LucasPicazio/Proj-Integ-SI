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
@Table(name="COMMENT")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	@ForeignKey(name="fk_memberId_comment")
	private Member memberId;

	@ManyToOne
	@JoinColumn(name="productId")
	@ForeignKey(name="fk_productId_comment")
	private Product productId;

	private String message;
	
	

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public Member getMember() {
		return memberId;
	}

	public void setMember(Member memberId) {
		this.memberId = memberId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
