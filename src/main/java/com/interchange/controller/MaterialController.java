package com.interchange.controller;

import com.interchange.dto.MaterialDTO.MaterialDTO;
import com.interchange.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @GetMapping("/listMaterials")
    public ResponseEntity<?> listMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }
    @PostMapping("/addMaterial")
    public ResponseEntity<?> addMaterial(@RequestBody MaterialDTO materialDTO) {
        return materialService.addMaterial(materialDTO);
    }
    @PutMapping("/updateMaterial/{materialId}")
    public ResponseEntity<?> updateMaterial(@PathVariable int materialId, @RequestBody MaterialDTO materialDTO) {
        return materialService.updateMaterial(materialId, materialDTO);
    }
}
