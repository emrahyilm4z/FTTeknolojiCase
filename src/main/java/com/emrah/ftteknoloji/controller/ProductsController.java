package com.emrah.ftteknoloji.controller;

import com.emrah.ftteknoloji.business.ProductService;
import com.emrah.ftteknoloji.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(this.productService.getAll().getBody(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        int lastIdOfItem = getAll().getBody().isEmpty() ? 0 : getAll().getBody().get(getAll().getBody().size()-1).getId() ;
        product.setId(lastIdOfItem + 1);
        return new ResponseEntity<Product>(this.productService.add(product).getBody(), HttpStatus.OK);
    }

    @GetMapping("/getExpiredDate")
    public ResponseEntity<List<Product>> getExpiredDate() {
        return this.productService.getExpiredDate();
    }

    @GetMapping("/getNotExpiredDate")
    public ResponseEntity<List<Product>> getNotExpiredDate() {
        return this.productService.getNotExpiredDate();
    }


}
