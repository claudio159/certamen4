/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Controller;

import inacap.webcomponent.prueba4.Model.CombustibleModel;
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
import inacap.webcomponent.prueba4.Model.TipoPersonaModel;
import inacap.webcomponent.prueba4.Repository.TipoPersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;
    
    @GetMapping()
    public Iterable<TipoPersonaModel> listarTodos() {
        
        return tipoPersonaRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> muestraTipopersona(@PathVariable String id) {
        
        Optional<TipoPersonaModel> cOptional = tipoPersonaRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            
            return new ResponseEntity(cOptional.get(), HttpStatus.FOUND);
            
        } else {
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> editarTipopersona(@PathVariable String id, @RequestBody TipoPersonaModel TipoPersonaEditar) {
        
        Optional<TipoPersonaModel> tOptional = tipoPersonaRepository.findById(Integer.parseInt(id));

        if (tOptional.isPresent()) {
            
            TipoPersonaModel tEncontrado = tOptional.get();
            
            TipoPersonaEditar.setIdPersona(tEncontrado.getIdPersona());
            
            tipoPersonaRepository.save(TipoPersonaEditar);
            return new ResponseEntity(tOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTipoPersona(@RequestBody TipoPersonaModel nuevoTipoPersona) {
        
        nuevoTipoPersona = tipoPersonaRepository.save(nuevoTipoPersona);
        
        Optional<TipoPersonaModel> cOptional = tipoPersonaRepository.findById(nuevoTipoPersona.getIdPersona());

        if (cOptional.isPresent()) {
            return new ResponseEntity(cOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
      
        Optional<TipoPersonaModel> cOptional = tipoPersonaRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            
            tipoPersonaRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity(cOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
