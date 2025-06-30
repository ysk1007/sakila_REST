package com.example.api.dto;

import lombok.Data;

@Data
public class CustomerDto {
	private int customerId;
	private int storeId;
	private String firstName;
	private String lastName;
	private String email;
	private int addressId;
	private int active;
	private String createDate;
}
