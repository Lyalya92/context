package ru.geekbrains.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public ProductRepository(){

    }

    @PostConstruct
    public void init (){
        products = new ArrayList<>(Arrays.asList(
                new Product(224475L,"Book", 240.0),
                new Product(190733L,"Pen", 35.0),
                new Product(145387L,"Pencil", 20.0),
                new Product(890734L,"Ruler", 120.0),
                new Product(395371L,"Pencil-box", 320.0)
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Product> getListOfProducts(){
        return products;
    }

}
