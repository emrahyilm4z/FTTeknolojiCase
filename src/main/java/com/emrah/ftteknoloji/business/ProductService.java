package com.emrah.ftteknoloji.business;

import com.emrah.ftteknoloji.dataAcces.ProductDao;
import com.emrah.ftteknoloji.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;


    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public ResponseEntity<Product> add(Product product) {
        this.productDao.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(this.productDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getExpiredDate() {
        LocalDate ld = LocalDate.now();
        List<Product> array = new ArrayList<>();
        getAll().getBody().forEach((item -> {
            if (item.getExpiredDate() != null) {
                if (ld.isAfter(item.getExpiredDate())) {
                    array.add(item);
                }
            }
        }));
        return new ResponseEntity<>(array, HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getNotExpiredDate() {
        LocalDate ld = LocalDate.now();
        List<Product> array = new ArrayList<>();
        getAll().getBody().forEach((item -> {
            if (item.getExpiredDate() == null) {
                array.add(item);
            } else if (ld.isBefore(item.getExpiredDate())) {
                array.add(item);
            }
        }));
        return new ResponseEntity<>(array, HttpStatus.OK);
    }


}
