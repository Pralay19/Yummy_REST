package com.yummyrest.yummy_rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.retrieveProduct(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable("id") Long id, @RequestBody @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(productService.updateProduct(request, id));
    }
    @GetMapping("/query")
    public ResponseEntity<List<ProductResponse>> getTopNProductsInPriceRangeXY(
            @RequestParam Long numProducts, @RequestParam double priceFrom, @RequestParam double priceTill
    ) {
        return ResponseEntity.ok(productService.getTopNProductsInPriceRangeXY(numProducts, priceFrom, priceTill));
    }
}
