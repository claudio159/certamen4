/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.prueba4.Model.RegionModel;
import inacap.webcomponent.prueba4.Repository.RegionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
    @Autowired
    private RegionRepository regionRepository;
    
    @GetMapping()
    public Iterable<RegionModel> listarTodos() {
        
        return regionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RegionModel> muestraRegion(@PathVariable String id) {
        
         Optional<RegionModel> rOptional = regionRepository.findById(Integer.parseInt(id));

        if (rOptional.isPresent()) {
            return new ResponseEntity(rOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }       
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> editarRegion(@PathVariable String id, @RequestBody RegionModel regioneditar) {
        
         Optional<RegionModel> cOptional = regionRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            RegionModel rEncontrado = cOptional.get();
            regioneditar.setIdRegion(rEncontrado.getIdRegion());
            regionRepository.save(regioneditar);
            return new ResponseEntity(cOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarRegion(@RequestBody RegionModel nuevaRegion) {
        
        nuevaRegion = regionRepository.save(nuevaRegion);
        
         Optional<RegionModel> cOptional = regionRepository.findById(nuevaRegion.getIdRegion());

        if (cOptional.isPresent()) {
            return new ResponseEntity(cOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
         Optional<RegionModel> cOptional = regionRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            
            regionRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity(cOptional.get(), HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
