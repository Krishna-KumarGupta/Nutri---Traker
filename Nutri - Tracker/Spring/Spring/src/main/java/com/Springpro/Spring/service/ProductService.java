package com.Springpro.Spring.service;

import com.Springpro.Spring.Item_List;
import com.Springpro.Spring.repository.ItemListRepository; // Adjust the import based on your actual repository package
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ItemListRepository itemListRepository;

    public Item_List findByBarcode(Long barcode) {
        Optional<Item_List> optionalItemList = itemListRepository.findByCode(barcode);
        return optionalItemList.orElse(null); // Return null if not found
    }
}
