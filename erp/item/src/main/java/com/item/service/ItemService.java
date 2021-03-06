package com.item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.item.model.Item;

@Service
public interface ItemService {
	
	public List<Item> getItems();
	
	public Item getItem(Long id);

	public Item saveItem(Item item);
	
	public void deleteItem(Long id);
		
}
