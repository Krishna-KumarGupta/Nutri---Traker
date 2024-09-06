package com.Springpro.Spring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;
import java.util.Arrays;

@Entity
@Data
@Table(name = "ITEM_LIST")
public class Item_List {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CODE", columnDefinition = "LONG")
    private Long code;

    @Column(name = "PDT_NAME")
    private String productName;

    @Column(name = "PDT_ING", columnDefinition = "LONGTEXT")
    private String ingredientsString;

    // Convert ingredients string to a List<String>
    public List<String> getIngredients() {
        if (ingredientsString != null && !ingredientsString.isEmpty()) {
            return Arrays.asList(ingredientsString.split(","));
        } else {
            return List.of(); // Return an empty list if there are no ingredients
        }
    }

    // Convert List<String> to a comma-separated string for storage
    public void setIngredients(List<String> ingredients) {
        if (ingredients != null && !ingredients.isEmpty()) {
            this.ingredientsString = String.join(",", ingredients);
        } else {
            this.ingredientsString = "";
        }
    }
}
