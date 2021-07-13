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
	
	public int storeNo() {
        return storeNo;
    }
    
    public String storeName() {
        return storeName;
    }
    public String storePic() {
        return storePic;
    }
    public String address() {
        return address;
    }
    public String hours() {
        return hours;
    }
    public String closedDays() {
        return closedDays;
    }
    public String callNumber() {
        return callNumber;
    }
    public String manageNo() {
        return manageNo;
    }


}
