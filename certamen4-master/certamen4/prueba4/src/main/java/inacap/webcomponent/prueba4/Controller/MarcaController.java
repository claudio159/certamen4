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
import inacap.webcomponent.prueba4.Model.MarcaModel;
import inacap.webcomponent.prueba4.Repository.MarcaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping()
    public Iterable<MarcaModel> listarTodos() {

        return marcaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> muestraMarca(@PathVariable String id) {

        Optional<MarcaModel> mOptional = marcaRepository.findById(Integer.parseInt(id));

        if (mOptional.isPresent()) {
            return new ResponseEntity(mOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> editarmarca(@PathVariable String id, @RequestBody MarcaModel marcaeditar) {

        Optional<MarcaModel> cOptional = marcaRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            
            MarcaModel mEncontrado = cOptional.get();
            marcaeditar.setIdMarca(mEncontrado.getIdMarca());
            return new ResponseEntity(marcaeditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }

    }

    @PostMapping
    public ResponseEntity<?> agregarmarca(@RequestBody MarcaModel nuevamarca) {
        
        nuevamarca = marcaRepository.save(nuevamarca);
        
        Optional<MarcaModel>mOptional = marcaRepository.findById(nuevamarca.getIdMarca());
        
        if(mOptional.isPresent()){
            return new ResponseEntity(mOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MarcaModel> mOptional = marcaRepository.findById(Integer.parseInt(id));

        if (mOptional.isPresent()) {
            
            marcaRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity(mOptional.get(), HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
