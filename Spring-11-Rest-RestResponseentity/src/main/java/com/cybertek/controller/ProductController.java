package com.cybertek.controller;


import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@RestController
@RequestMapping ("/products")

public class ProductController {

// passing headers
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping( value = "/{id}")
    public ResponseEntity <Product> getProduct (@PathVariable ("id") long id ){

        return ResponseEntity.ok(productService.getProduct(id));


    }

// all products
    @GetMapping
    public ResponseEntity <List <Product> > getProducts(){

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Cybertek.v1");
        responseHttpHeaders.set("Opertaion", "Get List");

        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(productService.getProducts());

    }



    //create product

    @PostMapping
    public ResponseEntity <List<Product>> createProduct(@RequestBody Product product){

        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "Cybertek.V1")
                .header("Operation", "Create")
                .body(set);
    }


    // delete product
    @DeleteMapping ( value = "/{id}")
    public ResponseEntity <List<Product>> deleteProduct (@PathVariable("id") long id){
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Cybertek.v1");
        responseHttpHeaders.set("Opertaion", "Delete");
        List <Product> list =productService.delete(id);
        return new ResponseEntity<>(list, responseHttpHeaders, HttpStatus.OK);

    }




    // update product


    @PutMapping (value = "/{id}")
    public ResponseEntity <List<Product>> updateProduct (@PathVariable ("id") long id , @RequestBody Product product ){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("Version","Cybertek.V3");
        map.add("Opertaion", "Update");

        List <Product> list = productService.updateProduct(id, product);
        return  new ResponseEntity<>( list, map, HttpStatus.OK);


    }

//{{Local}}api/products/read
    @GetMapping ("/read")
    public ResponseEntity <ResponseWrapper> readAllProducts(){
        return  ResponseEntity
                .ok( new ResponseWrapper("products successfully retrieved", productService.getProducts()));

    }

//{{Local}}api/products/delete/1
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<ResponseWrapper>deleteProduct2 (@PathVariable ("id") long id){

        return ResponseEntity.ok(new ResponseWrapper("product is deleted"));
    }

// {{Local}}api/products/delete2/1
    @DeleteMapping ("/delete2/{id}")
    public  ResponseEntity< ResponseWrapper>deleteProduct3 (@PathVariable("id") long id){
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("Product Successfully delted "));
    }

}
