package com.mthree.DTOs;


public class ExecutedOrder {

	int sellerOrderId;
	int buyerOrderId;
	int askPrice;
	int bidPrice;
	int shareCompanyId;
	int numberOfShares;
	int commission;
	public int getSellerOrderId() {
		return sellerOrderId;
	}
	public void setSellerOrderId(int sellerOrderId) {
		this.sellerOrderId = sellerOrderId;
	}
	public int getBuyerOrderId() {
		return buyerOrderId;
	}
	public void setBuyerOrderId(int buyerOrderId) {
		this.buyerOrderId = buyerOrderId;
	}
	public int getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(int askPrice) {
		this.askPrice = askPrice;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getShareCompanyId() {
		return shareCompanyId;
	}
	public void setShareCompanyId(int shareCompanyId) {
		this.shareCompanyId = shareCompanyId;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "ExecutedOrder [sellerOrderId=" + sellerOrderId + ", buyerOrderId=" + buyerOrderId + ", askPrice="
				+ askPrice + ", bidPrice=" + bidPrice + ", shareCompanyId=" + shareCompanyId + ", numberOfShares="
				+ numberOfShares + ", commission=" + commission + "]";
	}
	public ExecutedOrder(int sellerOrderId, int buyerOrderId, int askPrice, int bidPrice, int shareCompanyId,
			int numberOfShares, int commission) {
		super();
		this.sellerOrderId = sellerOrderId;
		this.buyerOrderId = buyerOrderId;
		this.askPrice = askPrice;
		this.bidPrice = bidPrice;
		this.shareCompanyId = shareCompanyId;
		this.numberOfShares = numberOfShares;
		this.commission = commission;
	}
	public ExecutedOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

