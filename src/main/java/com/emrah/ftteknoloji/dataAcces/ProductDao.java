package com.emrah.ftteknoloji.dataAcces;

import com.emrah.ftteknoloji.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao extends MongoRepository<Product,Integer > {
}
