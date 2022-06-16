package com.dasha.despensapp.services;

import com.dasha.despensapp.controller.dto.ProductDTO;
import com.dasha.despensapp.controller.dto.ShoppingInventoryDTO;
import com.dasha.despensapp.controller.dto.ShoppingProductDTO;
import com.dasha.despensapp.controller.dto.UserNameDTO;
import com.dasha.despensapp.repository.ProductRepository;
import com.dasha.despensapp.repository.ShoppingProductRepository;
import com.dasha.despensapp.repository.UserRepository;
import com.dasha.despensapp.repository.entity.InventoryJPA;
import com.dasha.despensapp.repository.entity.ProductJPA;
import com.dasha.despensapp.repository.entity.ShoppingProductJPA;
import com.dasha.despensapp.repository.entity.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingProductService {

    @Autowired
    private ShoppingProductRepository shoppingProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public ShoppingProductDTO insertShoppingProduct(ShoppingProductDTO shoppingProductDTO) {
        shoppingProductDTO.setAddedDate(LocalDateTime.now());
        shoppingProductDTO.setBuyedDate(null);
        shoppingProductDTO.setBuyed(Boolean.FALSE);
        shoppingProductDTO.setUserBuyed(null);
        ShoppingProductJPA jpa = mapToJPA(shoppingProductDTO);
        jpa = shoppingProductRepository.save(jpa);
        return mapToDTO(jpa);
    }

    public List<ShoppingInventoryDTO> findShoppingInventoryByUserId(Long userId) {
        List<InventoryJPA> inventories = shoppingProductRepository.findShoppingInventoriesByUserId(userId);
        List<ShoppingInventoryDTO> dtos = new ArrayList<>();
        for (InventoryJPA jpa : inventories) {
            ShoppingInventoryDTO shoppingInventoryDTO = mapToDTO(jpa);
            if (!shoppingInventoryDTO.getProducts().isEmpty()) {
                dtos.add(shoppingInventoryDTO);
            }
        }
        return dtos;
    }

    public boolean isValidProduct(Long productId) {
        Optional<ShoppingProductJPA> opt = shoppingProductRepository.findByProductIdAndBuyedFalse(productId);
        return opt.isEmpty();
    }

    public ShoppingProductDTO updateShoppingProduct(Long idShoppingProduct, BigDecimal amount) {
        ShoppingProductJPA jpa = shoppingProductRepository.getById(idShoppingProduct);
        jpa.setAmount(amount);
        jpa = shoppingProductRepository.save(jpa);
        return mapToDTO(jpa);
    }

    private ShoppingProductDTO mapToDTO(ShoppingProductJPA jpa) {
        ShoppingProductDTO dto = new ShoppingProductDTO();
        dto.setId(jpa.getId());
        dto.setBuyed(jpa.getBuyed());
        dto.setProduct(mapToDTO(jpa.getProduct()));
        dto.setAddedDate(jpa.getAddedDate());
        dto.setBuyedDate(jpa.getBuyedDate());
        dto.setUserAdded(mapToDTO(jpa.getUserAdded()));
        dto.setUserBuyed(mapToDTO(jpa.getUserBuyed()));
        dto.setAmount(jpa.getAmount());
        return dto;
    }

    private ShoppingProductJPA mapToJPA(ShoppingProductDTO shoppingProductDTO) {
        ShoppingProductJPA jpa = new ShoppingProductJPA();
        jpa.setProduct(productRepository.getById(shoppingProductDTO.getProduct().getId()));
        jpa.setAmount(shoppingProductDTO.getAmount());
        jpa.setAddedDate(shoppingProductDTO.getAddedDate());
        jpa.setBuyedDate(shoppingProductDTO.getBuyedDate());
        jpa.setBuyed(shoppingProductDTO.getBuyed());
        if (shoppingProductDTO.getUserAdded() != null) {
            jpa.setUserAdded(userRepository.getById(shoppingProductDTO.getUserAdded().getId()));
        }
        if (shoppingProductDTO.getUserBuyed() != null) {
            jpa.setUserBuyed(userRepository.getById(shoppingProductDTO.getUserBuyed().getId()));
        }
        return jpa;
    }

    private ProductDTO mapToDTO(ProductJPA jpa) {
        ProductDTO dto = new ProductDTO();
        dto.setId(jpa.getId());
        dto.setName(jpa.getName());
        dto.setDescription(jpa.getDescription());
//        dto.setCategory(mapToDTO(jpa.getCategory()));
        dto.setPhoto(jpa.getPhoto());
        dto.setAmount(jpa.getAmount());
        return dto;
    }

    private UserNameDTO mapToDTO(UserJPA jpa) {
        if (jpa == null) {
            return null;
        }
        UserNameDTO dto = new UserNameDTO();
        dto.setId(jpa.getId());
        dto.setName(jpa.getName());
        return dto;
    }

    private ShoppingInventoryDTO mapToDTO(InventoryJPA jpa) {
        ShoppingInventoryDTO dto = new ShoppingInventoryDTO();
        List<ShoppingProductDTO> shopProducts = new ArrayList<>();
        dto.setInventoryId(jpa.getId());
        dto.setName(jpa.getName());
        for (ProductJPA productJPA : jpa.getProducts()) {
            if (!productJPA.getShoppingProducts().isEmpty()) {
                shopProducts.add(mapToShoppingProductDTO(productJPA));
            }
        }
        dto.setProducts(shopProducts);
        return dto;
    }

    private ShoppingProductDTO mapToShoppingProductDTO(ProductJPA jpa) {
        ShoppingProductDTO dto = new ShoppingProductDTO();
        ShoppingProductJPA shoppingProductJPA = jpa.getShoppingProducts().get(0);
        dto.setUserAdded(mapToDTO(shoppingProductJPA.getUserAdded()));
        dto.setProduct(mapToDTO(jpa));
        dto.setBuyed(shoppingProductJPA.getBuyed());
        dto.setAmount(shoppingProductJPA.getAmount());
        dto.setId(shoppingProductJPA.getId());
        dto.setAddedDate(shoppingProductJPA.getAddedDate());
        return dto;
    }
}
