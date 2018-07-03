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
import inacap.webcomponent.prueba4.Model.PersonaModel;
import inacap.webcomponent.prueba4.Repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/Persona")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping()
    public Iterable<PersonaModel> listarTodo() {
        
        return personaRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> muestraPersona(@PathVariable String id) {
        
        Optional<PersonaModel> pOptional = personaRepository.findById(Integer.parseInt(id));
        
        if(pOptional.isPresent()){
            return  new ResponseEntity<>(pOptional.get(), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> editarPersona(@PathVariable String id, @RequestBody PersonaModel PersonaEditar) {
        
        Optional<PersonaModel> pOptional = personaRepository.findById(Integer.parseInt(id));
        
        if(pOptional.isPresent()){
            
            PersonaModel pEncontrados = pOptional.get();
            PersonaEditar.setIdPersona(pEncontrados.getIdPersona());
            
            personaRepository.save(PersonaEditar);
            return  new ResponseEntity<>(pOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaModel nuevaPersona) {
        
        Optional<PersonaModel> pOptional = personaRepository.findById(nuevaPersona.getIdPersona());
        
        if(pOptional.isPresent()){
            return  new ResponseEntity<>(pOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<PersonaModel> pOptional = personaRepository.findById(Integer.parseInt(id));
        
        if(pOptional.isPresent()){
            
            
            personaRepository.deleteById(Integer.parseInt(id));
            return  new ResponseEntity<>(pOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
