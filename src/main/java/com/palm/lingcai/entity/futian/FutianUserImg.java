package com.palm.lingcai.entity.futian;


public class FutianUserImg {

	//alias
	public static final String TABLE_ALIAS = "FutianUserImg";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_DEALER_ID = "dealerId";
	public static final String ALIAS_CHANNEL_ID = "channelId";
	public static final String ALIAS_IF_USE = "ifUse";
	public static final String ALIAS_IMG = "img";
	public static final String ALIAS_CREATE_TIME = "createTime";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * ç”¨æˆ·ID
	 */
	private Integer userId;
	/**
	 * ç»�é”€å•†ID
	 */
	private Integer dealerId;
	/**
	 * æ¸ é�“ç”¨æˆ·ID
	 */
	private Integer channelId;
	/**
	 * æ˜¯å�¦ä½¿ç”¨è¿‡ï¼š0æœªä½¿ç”¨ 1ä½¿ç”¨
	 */
	private Integer ifUse;
	/**
	 * ä¸Šä¼ å›¾ç‰‡
	 */
	private String img;
	/**
	 * åˆ›å»ºæ—¶é—´
	 */
	private java.util.Date createTime;

	private String userName;

	private String dealerName;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
	public Integer getDealerId() {
		return this.dealerId;
	}
	
	public void setDealerId(Integer value) {
		this.dealerId = value;
	}
	public Integer getChannelId() {
		return this.channelId;
	}
	
	public void setChannelId(Integer value) {
		this.channelId = value;
	}
	public Integer getIfUse() {
		return this.ifUse;
	}
	
	public void setIfUse(Integer value) {
		this.ifUse = value;
	}
	public String getImg() {
		return this.img;
	}
	
	public void setImg(String value) {
		this.img = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
}