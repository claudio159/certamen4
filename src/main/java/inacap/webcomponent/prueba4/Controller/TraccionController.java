/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.prueba4.Model.TraccionModel;
import inacap.webcomponent.prueba4.Repository.TraccionRepository;
import java.util.Optional;
import org.springframework.http.HttpStatus;


/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class TraccionController {
    
    @Autowired
    private TraccionRepository traccionRepository;
    
    @GetMapping()
    public Iterable<TraccionModel> listarTodos() {
        
        return traccionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity <TraccionModel>muestraTraccion(@PathVariable String id) {
        
        Optional<TraccionModel>tcOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if(tcOptional.isPresent()){
            return new ResponseEntity(tcOptional.get(), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> editartraccion(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
        
        Optional<TraccionModel> tcOptional = traccionRepository.findById(Integer.parseInt(id));
        
        
        if(tcOptional.isPresent()){
            TraccionModel cEncontrado = tcOptional.get();
            
            traccionEditar.setIdTraccion(cEncontrado.getIdTraccion());
            
            traccionRepository.save(traccionEditar);
            
            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregartraccion(@RequestBody TraccionModel nuevotraccion) {
        
        nuevotraccion = traccionRepository.save(nuevotraccion);
        
        Optional<TraccionModel>cOptional = traccionRepository.findById(nuevotraccion.getIdTraccion());
        
        if(cOptional.isPresent()){
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TraccionModel>dOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if(dOptional.isPresent()){
            traccionRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(dOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
              
    }
    
}
