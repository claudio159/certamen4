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
import inacap.webcomponent.prueba4.Model.TransmisionModel;
import inacap.webcomponent.prueba4.Repository.TransmisionRepository;
import java.util.Optional;
import javax.swing.plaf.basic.ComboPopup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    @GetMapping()
    public Iterable<TransmisionModel> listarTodos() {
        
        return transmisionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TransmisionModel> muestraTransmision(@PathVariable String id) {
        
        Optional<TransmisionModel>cOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            return new ResponseEntity<>(cOptional.get(), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> editarcombustible(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar ) {
        
        Optional<TransmisionModel> cOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            TransmisionModel cEncontrado = cOptional.get();
            
            transmisionEditar.setIdTransmision(cEncontrado.getIdTransmision());
            
            transmisionRepository.save(transmisionEditar);
            
            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTransmision(@RequestBody TransmisionModel nuevaTransmision) {
        
        nuevaTransmision = transmisionRepository.save(nuevaTransmision);
        
        Optional<TransmisionModel> cOptional = transmisionRepository.findById(nuevaTransmision.getIdTransmision());
        
        if(cOptional.isPresent()){
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TransmisionModel> cOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            transmisionRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
