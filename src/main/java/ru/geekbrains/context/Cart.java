package ru.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> productsInCart;
    private ProductRepository repository;

    public Cart() {

    }

    @PostConstruct
    public void init() {
        productsInCart = new ArrayList<>();
    }

    public void getToCart(Long id) {
        productsInCart.add(repository.findById(id));
    }

    public void removeFromCart(Long id) {
        productsInCart.remove(repository.findById(id));
    }

    public void showCartContent() {
        productsInCart.stream().forEach(System.out::println);
        System.out.println("Total: " + productsInCart.stream().mapToDouble(Product::getPrice).sum());
        System.out.println();
    }

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }
}
