package com.example.ecommerce.controller;



import com.example.ecommerce.modal.Product;
import com.example.ecommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private productService productservice;

    @GetMapping("/hello")
    public String helloworld(){
        return "IT IS WORKING";
    }
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> allproducts(){
        return new ResponseEntity<>(productservice.allproducts(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/api/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productservice.getProductById(id);
        if (product!=null ) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/product/{id}/image")
    public ResponseEntity<byte[]> getProductByIdImage(@PathVariable int id) {
        Product product = productservice.getProductById(id);
        return  new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
    }

    @PostMapping(value="/api/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile ImageFile) {
        Product savedProduct = null;
        try {
            savedProduct = productservice.addproductwithimage(product, ImageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value="/api/product{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile ImageFile) {
        Product savedProduct = null;
        try {
            savedProduct = productservice.updateProduct(id,product, ImageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productservice.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/api/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = productservice.searchProducts(keyword);
        System.out.println("searching with :" + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
