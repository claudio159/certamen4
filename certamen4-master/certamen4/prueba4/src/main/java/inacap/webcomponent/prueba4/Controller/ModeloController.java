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
import inacap.webcomponent.prueba4.Model.ModeloModel;
import inacap.webcomponent.prueba4.Repository.ModeloRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class ModeloController {
    
    @Autowired
    private ModeloRepository modeloRepository;
               
    @GetMapping()
    public Iterable<ModeloModel> listarTodos() {
        
        return modeloRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ModeloModel> muestamodelo(@PathVariable String id) {
       
        Optional<ModeloModel> cOptional = modeloRepository.findById(Integer.parseInt(id));
                
        if(cOptional.isPresent()){
            
            return new ResponseEntity<>(cOptional.get(), HttpStatus.FOUND);
            
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
            
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> editarmodelo(@PathVariable String id, @RequestBody ModeloModel modeloeditar) {
       
        Optional<ModeloModel> cOptional = modeloRepository.findById(Integer.parseInt(id));
                
        if(cOptional.isPresent()){
            ModeloModel cEncontrado = cOptional.get();
            modeloeditar.setIdModelo(cEncontrado.getIdModelo());
            return new ResponseEntity<>(modeloeditar, HttpStatus.OK);
            
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarmodelo(@RequestBody ModeloModel nuevomodelo) {
        
        nuevomodelo = modeloRepository.save(nuevomodelo);
        
        Optional<ModeloModel> cOptional = modeloRepository.findById(nuevomodelo.getIdModelo());
                
        if(cOptional.isPresent()){
            
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
            
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<ModeloModel> cOptional = modeloRepository.findById(Integer.parseInt(id));
                
        if(cOptional.isPresent()){
            modeloRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(cOptional.get(), HttpStatus.FOUND);
            
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
