package com.ctk.demo.zk.vo;

public class FunctionVo {

	private String category;
	private String name;

	public FunctionVo(String category) {
		super();
		this.category = category;
		this.name = null;
	}

	public FunctionVo(String category, String name) {
		super();
		this.category = category;
		this.name = name;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
