package com.cognizant.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int productId;
	private String productName;
	private double productPrice;
	private int profileid;
	private String profilename;
	private String profiletype;

	public Orders(int productId, String productName, double productPrice, int profileid, String profilename,
			String profiletype) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.profileid = profileid;
		this.profilename = profilename;
		this.profiletype = profiletype;
	}

}
