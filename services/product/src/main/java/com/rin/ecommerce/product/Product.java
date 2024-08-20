package com.rin.ecommerce.product;

import com.rin.ecommerce.category.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String description;
    double availableQuantity;
    BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
