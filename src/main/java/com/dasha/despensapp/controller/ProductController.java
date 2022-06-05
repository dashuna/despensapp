package com.dasha.despensapp.controller;

import com.dasha.despensapp.controller.dto.ProductDTO;
import com.dasha.despensapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts(@RequestParam Long idInventory) {
        return productService.getProducts(idInventory);
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }
}
