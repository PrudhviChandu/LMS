package com.te.lms.ourenum;

public enum AddressType {

	
	  permanent("permanent"), temporary("temporary"), 
	  p("p"),t("t");
	  
	  private final String addressType;
	  
	  private AddressType(String addressType) {
	  this.addressType = addressType;
	    }
	  
	  public String getAddressType() {
	  return addressType;
	    }
	 
	//permanent, temporary;

}
