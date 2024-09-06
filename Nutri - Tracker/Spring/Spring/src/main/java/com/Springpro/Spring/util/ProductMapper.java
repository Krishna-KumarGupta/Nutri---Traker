package com.Springpro.Spring.util;

import com.Springpro.Spring.Item_List;
import com.Springpro.Spring.model.Product;
import java.util.List;
import java.util.Arrays;

public class ProductMapper {

    public static Product toProduct(Item_List itemList) {
        return new Product(
                itemList.getCode().toString(), // Convert Long to String
                itemList.getProductName(),
                convertIngredientsStringToList(itemList.getIngredientsString())
        );
    }

    public static Item_List toItemList(Product product) {
        Item_List itemList = new Item_List();
        itemList.setCode(Long.parseLong(product.getBarcode())); // Convert String to Long for the barcode
        itemList.setProductName(product.getName());              // Map the product name
        itemList.setIngredients(product.getIngredients());       // Convert List<String> to a comma-separated string
        return itemList;
    }

    private static List<String> convertIngredientsStringToList(String ingredientsString) {
        if (ingredientsString != null && !ingredientsString.isEmpty()) {
            return Arrays.asList(ingredientsString.split(","));
        } else {
            return List.of(); // Return an empty list if there are no ingredients
        }
    }
}
