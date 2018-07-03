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
import inacap.webcomponent.prueba4.Model.CarroceriaModel;
import inacap.webcomponent.prueba4.Repository.CarroceriaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class CarroceriaController {
    
    @Autowired
    private CarroceriaRepository carroceriaRepository;
    
    @GetMapping()
    public Iterable<CarroceriaModel> listarTodos() {
        
        return carroceriaRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity <CarroceriaModel>muestraCarroceria(@PathVariable String id) {
        
        Optional<CarroceriaModel> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            CarroceriaModel cEncontrado = cOptional.get();
            return new ResponseEntity<>(cOptional.get(), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> editarCarroceria(@PathVariable String id, @RequestBody CarroceriaModel carroceriaeditar) {
        
        Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            CarroceriaModel cEncontrado = aOptional.get();
            carroceriaeditar.setIdCarroceria(cEncontrado.getIdCarroceria());
            carroceriaRepository.save(carroceriaeditar);
            return new ResponseEntity<>(carroceriaeditar, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarCarroceria(@RequestBody CarroceriaModel nuevaCarroceria) {
        
        nuevaCarroceria = carroceriaRepository.save(nuevaCarroceria);
        
        Optional<CarroceriaModel> cOptional = carroceriaRepository.findById(nuevaCarroceria.getIdCarroceria());
        
        if(cOptional.isPresent()){
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
                    
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CarroceriaModel>cOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            carroceriaRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
