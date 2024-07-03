package com.aaradhya.sb.learnspringbootjpa.service;

import com.aaradhya.sb.learnspringbootjpa.entity.Product;
import com.aaradhya.sb.learnspringbootjpa.repositoy.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return repository.findById(id);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        //assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        return repository.save(existingProduct);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);

        return "Product Removed!! with id = "+id;
    }
}
