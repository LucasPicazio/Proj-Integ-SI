package com.pisi.marketplace.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.Product;

public class TransactionResource {
	@JsonProperty("memberID")
	private Member memberID;

	@JsonProperty("productID")
	private Product productID;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("approvalStatus")
	private String approvalStatus;

	@JsonProperty("date")
	private String date;

	public Member getMemberID() {
		return memberID;
	}

	public void setMemberID(Member memberID) {
		this.memberID = memberID;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TransactionResource [memberID=" + memberID + ", productID=" + productID + ", quantity=" + quantity
				+ ", approvalStatus=" + approvalStatus + ", date=" + date + "]";
	}

}
