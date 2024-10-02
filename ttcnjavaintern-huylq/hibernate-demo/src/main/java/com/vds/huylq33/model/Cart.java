package com.vds.huylq33.model;

import com.vds.huylq33.model.Product;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }
}
