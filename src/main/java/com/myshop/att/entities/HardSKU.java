package com.myshop.att.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HARD_SKU")
public class HardSKU implements ISKU, Serializable {

	private static final long serialVersionUID = -2763349661409566436L;
	
	@Id
	private String id;
	@Enumerated(EnumType.STRING)
	private SKUType type;
	private String name;
	private String model;
	private String manufacturer;
	private String color;
	private String size;
	
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
