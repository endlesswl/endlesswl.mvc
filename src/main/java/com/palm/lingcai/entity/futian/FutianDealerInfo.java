package com.palm.lingcai.entity.futian;


public class FutianDealerInfo {

	//alias
	public static final String TABLE_ALIAS = "FutianDealerInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_DEALER_NAME = "dealerName";
	public static final String ALIAS_PROVINCE = "province";
	public static final String ALIAS_CITY = "city";
	public static final String ALIAS_CLIENT_CITY = "clientCity";
	public static final String ALIAS_TEL = "tel";
	public static final String ALIAS_ADDRESS = "address";
	public static final String ALIAS_CODE_URL = "codeUrl";
	public static final String ALIAS_CREATE_TIME = "createTime";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * ç»�é”€å•†ç”¨æˆ·å��
	 */
	private String dealerName;
	/**
	 * çœ�
	 */
	private Integer province;
	/**
	 * å¸‚
	 */
	private Integer city;
	/**
	 * å®¢æˆ·åŸŽå¸‚
	 */
	private Integer clientCity;
	/**
	 * ç”µè¯�å�·ç �
	 */
	private String tel;
	/**
	 * åœ°å�€
	 */
	private String address;
	/**
	 * äºŒç»´ç �åœ°å�€
	 */
	private String codeUrl;
	/**
	 * åˆ›å»ºæ—¶é—´
	 */
	private java.util.Date createTime;

	private String clientCityName;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public String getDealerName() {
		return this.dealerName;
	}
	
	public void setDealerName(String value) {
		this.dealerName = value;
	}
	public Integer getProvince() {
		return this.province;
	}
	
	public void setProvince(Integer value) {
		this.province = value;
	}
	public Integer getCity() {
		return this.city;
	}
	
	public void setCity(Integer value) {
		this.city = value;
	}
	public Integer getClientCity() {
		return this.clientCity;
	}
	
	public void setClientCity(Integer value) {
		this.clientCity = value;
	}
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String value) {
		this.tel = value;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	public String getCodeUrl() {
		return this.codeUrl;
	}
	
	public void setCodeUrl(String value) {
		this.codeUrl = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public String getClientCityName() {
		return clientCityName;
	}

	public void setClientCityName(String clientCityName) {
		this.clientCityName = clientCityName;
	}
}