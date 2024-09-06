package com.Springpro.Spring.controller;

import com.Springpro.Spring.Item_List;
import com.Springpro.Spring.model.Product;
import com.Springpro.Spring.service.ProductService;
import com.Springpro.Spring.util.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{barcode}")
    public ResponseEntity<Product> getProductByBarcode(@PathVariable Long barcode) {
        Item_List itemList = productService.findByBarcode(barcode);
        if (itemList != null) {
            Product product = ProductMapper.toProduct(itemList);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
