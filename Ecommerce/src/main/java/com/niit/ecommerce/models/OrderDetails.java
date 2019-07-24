package com.niit.ecommerce.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int orderId;
private Date purchaseDate;
private double grandTotal;
@ManyToOne(cascade=CascadeType.ALL)
private User user;
//@OneToMany
//@JoinColumn(name="product_id")
//private Product product;


//public Product getProduct() {
//	return product;
//}
//public void setProduct(Product product) {
//	this.product = product;
//}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Date getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(Date purchaseDate) {
	this.purchaseDate = purchaseDate;
}
public double getGrandTotal() {
	return grandTotal;
}
public void setGrandTotal(double grandTotal) {
	this.grandTotal = grandTotal;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
