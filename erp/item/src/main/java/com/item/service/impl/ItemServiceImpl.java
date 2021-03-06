package com.item.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.entity.ItemEntity;
import com.item.model.Item;
import com.item.repository.ItemRepository;
import com.item.service.ItemService;

@Component("ItemServiceImpl")
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepo;

	@Override
	public List<Item> getItems() {
		return itemRepo.findAll().stream().map(i -> mappingEntityToItem(i)).collect(Collectors.toList());
	}

	@Override
	public Item getItem(Long id) {
		return mappingEntityToItem(itemRepo.findById(id).get());
	}

	@Override
	public Item saveItem(Item item) {
		return mappingEntityToItem(itemRepo.save(mappingItemToEntity(item)));
	}

	@Override
	public void deleteItem(Long id) {
		itemRepo.deleteById(id);
	}

	private Item mappingEntityToItem(ItemEntity itemEntity) {

		Item item = null;

		if(itemEntity!=null)
		item = new Item(itemEntity.getId(), itemEntity.getItemName(), itemEntity.getCost());

		return item;

	}


	private ItemEntity mappingItemToEntity(Item item) {

		ItemEntity itemEntity = null;

		if(item!=null)
			itemEntity = new ItemEntity(item.getId(), item.getItemName(),item.getCost());

		return itemEntity;

	}

	
}
