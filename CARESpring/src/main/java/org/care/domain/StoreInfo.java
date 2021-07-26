package org.care.domain;



public class StoreInfo {

	private int storeNo;
	private String storeName;
	private String storePic;
	private String address;
	private String hours;
	private String closedDays;
	private String callNumber;
	private String manageNo;
	
	
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePic() {
		return storePic;
	}
	public void setStorePic(String storePic) {
		this.storePic = storePic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getClosedDays() {
		return closedDays;
	}
	public void setClosedDays(String closedDays) {
		this.closedDays = closedDays;
	}
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	public String getManageNo() {
		return manageNo;
	}
	public void setManageNo(String manageNo) {
		this.manageNo = manageNo;
	}
	
	@Override
	public String toString() {
		return "StoreInfo [ storeNo=" + storeNo + " , storeName= " + storeName + " , storePic=" + storePic + " , address= " + address + " , hours = " + hours + " , closedDays = " + closedDays + " , callNumber= " + callNumber + " , manageNo = " + manageNo + "]";
	
}
}
