package com.epam.memento;

import java.io.Serializable;

public class OfferDataKeeper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String commend;
	private Integer productId;

	public String getComment() {
		return commend;
	}

	public void setComment(String commend) {
		this.commend = commend;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OfferData [commend=" + commend + ", productId=" + productId + "]";
	}

}
