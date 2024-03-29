package com.dasha.despensapp.controller;

import com.dasha.despensapp.config.JwtTokenUtil;
import com.dasha.despensapp.controller.dto.ProductDTO;
import com.dasha.despensapp.controller.dto.ShoppingInventoryDTO;
import com.dasha.despensapp.controller.dto.ShoppingProductDTO;
import com.dasha.despensapp.controller.dto.UserNameDTO;
import com.dasha.despensapp.services.ShoppingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shopping")
@CrossOrigin
public class ShoppingProductController {

    @Autowired
    private ShoppingProductService shoppingProductService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertShoppingProduct(@RequestBody ShoppingProductDTO shoppingProductDTO){
        if (shoppingProductService.isValidProduct(shoppingProductDTO.getProduct().getId())) {
            shoppingProductDTO.setUserAdded(buildActualUser());
            return new ResponseEntity<>(shoppingProductService.insertShoppingProduct(shoppingProductDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getShopping() {
        List<ShoppingInventoryDTO> shoppingInventory = shoppingProductService.findShoppingInventoryByUserId(jwtTokenUtil.getIdUser());
        return new ResponseEntity<>(shoppingInventory, HttpStatus.OK);
    }

    private UserNameDTO buildActualUser() {
        UserNameDTO dto = new UserNameDTO();
        dto.setId(jwtTokenUtil.getIdUser());
        return dto;
    }

    @PatchMapping
    public ShoppingProductDTO updateShoppingProduct(@RequestBody ShoppingProductDTO shoppingProductDTO) {
        return shoppingProductService.updateShoppingProduct(shoppingProductDTO.getId(), shoppingProductDTO.getAmount());
    }

    @PatchMapping(path = "/{idShoppingProduct}/buy")
    public ShoppingProductDTO buyShoppingProduct(@PathVariable Long idShoppingProduct) {
        return shoppingProductService.buyShoppingProduct(idShoppingProduct, jwtTokenUtil.getIdUser());
    }

    @DeleteMapping("{idShoppingProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idShoppingProduct) {
        shoppingProductService.deleteShoppingProduct(idShoppingProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
