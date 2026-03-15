package com.example.ecommerce.service;

import com.example.ecommerce.Repository.productRepository;
import com.example.ecommerce.modal.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productService {
    @Autowired
    private productRepository productrepo;

    public  List<Product> searchProducts(String keyword) {
        return productrepo.search(keyword);
    }

    public List<Product> allproducts() {
        return productrepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productrepo.findById(id).orElse(null);
    }

    public Product addproductwithimage(Product product, MultipartFile ImageFile) throws IOException {
        product.setImageData(ImageFile.getBytes());
        product.setImageName(ImageFile.getOriginalFilename());
        product.setImagetype(ImageFile.getContentType());
        return productrepo.save(product);
    }

    public Product updateProduct(Integer id,Product product, MultipartFile ImageFile) throws IOException {

        product.setImageData(ImageFile.getBytes());
        product.setImageName(ImageFile.getOriginalFilename());
        product.setImagetype(ImageFile.getContentType());
        return productrepo.save(product);
    }

    public void deleteProduct(int id) {
        productrepo.deleteById(id);
    }
}
