package com.cn.cnkart.service;

import javax.transaction.Transactional;

import com.cn.cnkart.dal.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	

	public Item getItemById(int id) {
		return itemRepository.findById(id).get();
	}


	public void saveItem(Item item) {
		itemRepository.save(item);
	}


	public void delete(int id) {
		itemRepository.deleteById(id);
		
	}


	public void update(Item updateItem) {
		// Method-1 to update the item and add it to the repository
			/* Item item = itemRepository.findById(updateItem.getId()).get();
			item.setName(updateItem.getName());
			item.setDescription(updateItem.getDescription());
			item.setItemDetails(updateItem.getItemDetails());
			item.setItemReview(updateItem.getItemReview());
			*/
		// A more simpler method to do the same and the repository will manage things on its own
		itemRepository.save(updateItem);
	}


	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<Item>();

//		List<Item> completeList = (List<Item>) itemRepository.findAll();
//		itemList.addAll(completeList);

		itemRepository.findAll().forEach(item->itemList.add(item));
		return itemList;
	}

	
}
