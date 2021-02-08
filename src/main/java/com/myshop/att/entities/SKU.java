package com.myshop.att.entities;

import java.io.Serializable;

public class SKU implements ISKU, Serializable {

	private static final long serialVersionUID = 6983589150536786299L;
	
	private String id;
	private SKUType type;
	private String name;
	
	@Override
	public String getId() {
		return this.id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public SKUType getType() {
		return this.type;
	}
	@Override
	public void setType(SKUType type) {
		this.type = type;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
