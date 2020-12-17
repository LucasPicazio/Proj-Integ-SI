
package com.pisi.marketplace.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pisi.marketplace.data.entity.Member;
import com.pisi.marketplace.data.entity.Product;

public class CartResource {


    @JsonProperty("memberID")
	private Member memberID;

    @JsonProperty("productID")
    private Product productID;

    @JsonProperty("quantity")
    private int quantity;

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

    public int getQuantity() {System.out.println(quantity);
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartResource [memberID=" + memberID + ", productID=" + productID + ", quantity="
                + quantity + "]";
    }

}
