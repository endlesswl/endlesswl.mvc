package com.palm.lingcai.entity.futian;


public class FutianUserInfo {

	//alias
	public static final String TABLE_ALIAS = "FutianUserInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_UNAME = "uname";
	public static final String ALIAS_UPWD = "upwd";
	public static final String ALIAS_MOBILE = "mobile";
	public static final String ALIAS_TEL = "tel";
	public static final String ALIAS_PROVINCE = "province";
	public static final String ALIAS_CITY = "city";
	public static final String ALIAS_CAR_TYPE = "carType";
	public static final String ALIAS_BRAND = "brand";
	public static final String ALIAS_CAR_MODEL = "carModel";
	public static final String ALIAS_DEALER_ID = "dealerId";
	public static final String ALIAS_DEALER = "dealer";
	public static final String ALIAS_CREATE_TIME = "createTime";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * ç”¨æˆ·å��
	 */
	private String uname;
	/**
	 * å¯†ç �
	 */
	private String upwd;
	/**
	 * æ‰‹æœºå�·
	 */
	private String mobile;
	/**
	 * ç”µè¯�å�·ç �
	 */
	private String tel;
	/**
	 * çœ�
	 */
	private Integer province;
	/**
	 * åŸŽå¸‚
	 */
	private Integer city;
	/**
	 * æ±½è½¦ç±»åž‹
	 */
	private String carType;
	/**
	 * å“�ç‰Œ
	 */
	private String brand;
	/**
	 * æ±½è½¦æ¬¾åž‹
	 */
	private String carModel;
	/**
	 * ç»�é”€å•†ID
	 */
	private Integer dealerId;
	/**
	 * ç»�é”€å•†
	 */
	private Integer channelId;
	/**
	 * åˆ›å»ºæ—¶é—´
	 */
	private java.util.Date createTime;

	private String cityName;

	private String channelName;

	private String provinceName;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public String getUname() {
		return this.uname;
	}
	
	public void setUname(String value) {
		this.uname = value;
	}
	public String getUpwd() {
		return this.upwd;
	}
	
	public void setUpwd(String value) {
		this.upwd = value;
	}
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String value) {
		this.mobile = value;
	}
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String value) {
		this.tel = value;
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
	public String getCarType() {
		return this.carType;
	}
	
	public void setCarType(String value) {
		this.carType = value;
	}
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String value) {
		this.brand = value;
	}
	public String getCarModel() {
		return this.carModel;
	}
	
	public void setCarModel(String value) {
		this.carModel = value;
	}
	public Integer getDealerId() {
		return this.dealerId;
	}
	
	public void setDealerId(Integer value) {
		this.dealerId = value;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}