package com.dasha.despensapp.controller;

import com.dasha.despensapp.config.JwtTokenUtil;
import com.dasha.despensapp.controller.dto.InventoryDTO;
import com.dasha.despensapp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public List<InventoryDTO> getInventories() {
        return inventoryService.getInventories(jwtTokenUtil.getIdUser());
    }

    //crear un nuevo inventario
    @PostMapping
    public InventoryDTO saveInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.saveInventory(inventoryDTO, jwtTokenUtil.getIdUser());
    }

    //compartir un inventario con otros usuarios
}
