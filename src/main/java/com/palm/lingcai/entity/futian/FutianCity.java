package com.palm.lingcai.entity.futian;


public class FutianCity {

	//alias
	public static final String TABLE_ALIAS = "FutianCity";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PROVINCE_ID = "provinceId";
	public static final String ALIAS_CITY = "city";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer provinceId;
	/**
	 * åŸŽå¸‚
	 */
	private String city;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getProvinceId() {
		return this.provinceId;
	}
	
	public void setProvinceId(Integer value) {
		this.provinceId = value;
	}
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String value) {
		this.city = value;
	}
}