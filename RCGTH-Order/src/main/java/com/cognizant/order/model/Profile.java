package com.cognizant.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	private int profileid;
	private String profilename;
	private String profiletype;

}
