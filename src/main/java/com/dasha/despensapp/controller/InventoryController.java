package com.dasha.despensapp.controller;

import com.dasha.despensapp.config.JwtTokenUtil;
import com.dasha.despensapp.controller.dto.InventoryDTO;
import com.dasha.despensapp.controller.dto.UserDTO;
import com.dasha.despensapp.controller.dto.UserInventoryDTO;
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

//    @GetMapping
//    public List<InventoryDTO> getInventories() {
//        return inventoryService.getInventories(jwtTokenUtil.getIdUser());
//    }
    @GetMapping
    public List<UserInventoryDTO> getInventories() {
        return inventoryService.getInventories(jwtTokenUtil.getIdUser());
    }

    //crear un nuevo inventario
    @PostMapping
    public InventoryDTO saveInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.saveInventory(inventoryDTO, jwtTokenUtil.getIdUser());
    }

    @GetMapping(path = "/{idInventory}/users")
    public List<UserDTO> getUsersByInventory(@PathVariable Long idInventory) {
        return inventoryService.getUserByInventory(idInventory);
    }

    @GetMapping(path = "/{idInventory}/user")
    public UserInventoryDTO getUserByInventory(@PathVariable Long idInventory) {
        return inventoryService.getByUserAndInventoryId(jwtTokenUtil.getIdUser(), idInventory);
    }

    //compartir un inventario con otros usuarios
    @PostMapping(path = "/{idInventory}/invitation/{user}")
    public UserInventoryDTO sendInvitation(@PathVariable Long idInventory, @PathVariable String user) {
        return inventoryService.sendInvitation(idInventory, user);
    }

    @PatchMapping(path = "/invitation")
    public void updateInvitation(@RequestBody UserInventoryDTO userInventoryDTO) {
        inventoryService.updateInvitation(userInventoryDTO.getId(), userInventoryDTO.getAccepted());
    }
}
