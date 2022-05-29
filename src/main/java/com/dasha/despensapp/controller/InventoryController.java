package com.dasha.despensapp.controller;

import com.dasha.despensapp.config.JwtTokenUtil;
import com.dasha.despensapp.controller.dto.InventoryDTO;
import com.dasha.despensapp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
