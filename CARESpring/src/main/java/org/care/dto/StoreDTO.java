package org.care.dto;


import lombok.Data;

@Data
public class StoreDTO {

	private int storeNo;
	private String storeName;
	private String storePic;
	private String address;
	private String hours;
	private String closedDays;
	private String callNumber;
	private String manageNo;
	private float storeAvg;
	private int reviewCount;
}

