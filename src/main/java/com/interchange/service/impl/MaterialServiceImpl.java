package com.interchange.service.impl;

import com.interchange.converter.MaterialConverter;
import com.interchange.dto.MaterialDTO.MaterialDTO;
import com.interchange.entities.Material;
import com.interchange.repository.MaterialRepository;
import com.interchange.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private MaterialConverter materialConverter;
    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addMaterial(MaterialDTO materialDTO) {
        Material material = materialConverter.toMaterial(materialDTO);
        materialRepository.save(material);
        return new ResponseEntity<>("Add material successfully!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateMaterial(int materialId, MaterialDTO materialDTO) {
        Material material = materialRepository.findFirstByMaterialId(materialId);
        if (material == null) {
            return new ResponseEntity<>("Material not found!", HttpStatus.NOT_FOUND);
        }
        material = materialConverter.toMaterial(materialDTO, material);
        materialRepository.save(material);
        return new ResponseEntity<>("Update material successfully!", HttpStatus.OK);
    }
}
