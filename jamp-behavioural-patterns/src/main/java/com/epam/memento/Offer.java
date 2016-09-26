package com.epam.memento;

import java.util.Date;

public class Offer {
	private int offerId;
	private Date dateCreated;
	private Date lastUpdateDate;
	private String comment;
	private int productId;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void updateData(OfferDataKeeper offerDataKeeper) {
		if (offerDataKeeper.getComment() != null) {
			this.comment = offerDataKeeper.getComment();
		}

		if (offerDataKeeper.getProductId() != null) {
			this.offerId = offerDataKeeper.getProductId();
		}

		this.lastUpdateDate = new Date();

	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", dateCreated=" + dateCreated + ", lastUpdateDate=" + lastUpdateDate
				+ ", comment=" + comment + ", productId=" + productId + "]";
	}

}
