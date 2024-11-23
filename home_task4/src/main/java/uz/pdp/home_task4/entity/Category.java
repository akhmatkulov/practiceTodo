package uz.pdp.home_task4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer id = idGen ++;
    private String categoryName;
    private static Integer idGen = 1;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
