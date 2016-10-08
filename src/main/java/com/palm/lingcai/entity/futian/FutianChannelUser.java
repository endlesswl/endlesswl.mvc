package com.palm.lingcai.entity.futian;


public class FutianChannelUser {

	//alias
	public static final String TABLE_ALIAS = "FutianChannelUser";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CHANNEL_NAME = "channelName";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_CODE_URL = "codeUrl";

	/**
	 * 
	 */
	private Integer id;
	/**
	 * æ¸ é�“ç”¨æˆ·å��
	 */
	private String channelName;
	/**
	 * å¤‡æ³¨
	 */
	private String content;
	/**
	 * æ¸ é�“ç”¨æˆ·äºŒç»´ç �
	 */
	private String codeUrl;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer value) {
		this.id = value;
	}
	public String getChannelName() {
		return this.channelName;
	}
	
	public void setChannelName(String value) {
		this.channelName = value;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String value) {
		this.content = value;
	}
	public String getCodeUrl() {
		return this.codeUrl;
	}
	
	public void setCodeUrl(String value) {
		this.codeUrl = value;
	}
}