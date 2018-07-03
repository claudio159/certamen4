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
import inacap.webcomponent.prueba4.Model.VehiculoModel;
import inacap.webcomponent.prueba4.Repository.VehiculoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class VehiculoController {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @GetMapping()
    public Iterable<VehiculoModel> listarTodos() {
        
        return vehiculoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoModel> muestraVehiculo(@PathVariable String id) {
        
        Optional<VehiculoModel> cOptional = vehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            VehiculoModel vEncontrado = cOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoModel> editarVehiculo(@PathVariable String id, @RequestBody VehiculoModel vehiculoEditar) {
        
        Optional<VehiculoModel> cOptional = vehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            VehiculoModel vEncontrado = cOptional.get();
            
            vehiculoEditar.setIdVehiculo(vEncontrado.getIdVehiculo());
            vehiculoRepository.save(vehiculoEditar);
            return new ResponseEntity<>(vehiculoEditar, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehiculoModel nuevovehiculo) {
        
        nuevovehiculo = vehiculoRepository.save(nuevovehiculo);
        
        Optional<VehiculoModel> cOptional = vehiculoRepository.findById(nuevovehiculo.getIdVehiculo());
        
        if(cOptional.isPresent()){
            VehiculoModel vEncontrado = cOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<VehiculoModel> cOptional = vehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            
            VehiculoModel vEncontrado = cOptional.get();
            
            vehiculoRepository.deleteById(vEncontrado.getIdVehiculo());
            return new ResponseEntity<>(vEncontrado, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
