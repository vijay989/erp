package com.item.model;

public class Item {

	Long id;
	String itemName;
	Long cost;
	
	public Item() {

	}
	
	public Item(Long id, String itemName, Long cost) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.cost = cost;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the cost
	 */
	public Long getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Long cost) {
		this.cost = cost;
	}
	
}
