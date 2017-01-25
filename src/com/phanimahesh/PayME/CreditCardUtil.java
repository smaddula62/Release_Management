package com.phanimahesh.PayME;

public class CreditCardUtil {

	

	private String cardNumber;
   	private int cvv;
  	private String expDate;
   	private String cardHolderName;  
	private String merchid;
   	private double amount;
   	private String result;
   	private double tax;
   	private double productPrice;
    
   	
   	
   	public CreditCardUtil(String cardNumber, int cvv, String expDate, String cardHolderName, String merchid,
			double amount, double tax,double productPrice) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expDate = expDate;
		this.cardHolderName = cardHolderName;
		this.merchid = merchid;
		this.amount = amount;
		this.tax = tax;
		this.setProductPrice(productPrice);
	}

	public String getResult() {
	return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	// Must have no-argument constructor
 	public CreditCardUtil() {

 	}

   	public CreditCardUtil(String cardNumber, int cvv, String expDate, String cardHolderName, String merchid,
			double amount) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expDate = expDate;
		this.cardHolderName = cardHolderName;
		this.merchid = merchid;
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public String getExpDate() {
		return expDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public String getMerchid() {
		return merchid;
	}

	public double getAmount() {
		return amount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
   	
   	

	
}

	

	
