package com.palm.lingcai.entity.futian;


public class FutianProvince {

	//alias
	public static final String TABLE_ALIAS = "FutianProvince";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PROVINCE = "province";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * çœ�
	 */
	private String province;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String value) {
		this.province = value;
	}
}