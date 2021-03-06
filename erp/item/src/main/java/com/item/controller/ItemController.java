package com.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.item.model.Item;
import com.item.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("ItemServiceImpl")
	ItemService itemService;

	@GetMapping("getItem/{itemId}")
	public ResponseEntity<Item> getItem(@PathVariable("itemId") Long itemId) {

		Item item = itemService.getItem(itemId);

		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}

	@GetMapping("getItems")
	public ResponseEntity<List<Item>> getItems() {

		List<Item> items = itemService.getItems();

		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@PostMapping(path = "createItems", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {

		Item items = itemService.saveItem(item);

		return new ResponseEntity<Item>(items, HttpStatus.CREATED);
	}

	@PutMapping(path = "updateItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {

		Item items = itemService.saveItem(item);

		return new ResponseEntity<Item>(items, HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteItem/{itemId}")
	public ResponseEntity<Void> deleteItems(@PathVariable("itemId") Long itemId) {

		itemService.deleteItem(itemId);

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
