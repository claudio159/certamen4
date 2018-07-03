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
import inacap.webcomponent.prueba4.Model.CiudadModel;
import inacap.webcomponent.prueba4.Repository.CiudadRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping()
    public Iterable<CiudadModel> listarTodos() {

        return ciudadRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CiudadModel> muestraCiudad(@PathVariable String id) {

        Optional<CiudadModel> cOptional = ciudadRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            return new ResponseEntity(cOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> editarCiudad(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {

        Optional<CiudadModel> cOptional = ciudadRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            CiudadModel cEncontrado = cOptional.get();

            ciudadEditar.setIdCuidad(cEncontrado.getIdCuidad());

            ciudadRepository.save(ciudadEditar);

            return new ResponseEntity(cOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> agragarCiudad(@RequestBody CiudadModel nuevaCiudad) {

        nuevaCiudad = ciudadRepository.save(nuevaCiudad);

        Optional<CiudadModel> cOptional = ciudadRepository.findById(nuevaCiudad.getIdCuidad());

        if (cOptional.isPresent()) {
            return new ResponseEntity(cOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<CiudadModel> cOptional = ciudadRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {

            ciudadRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity(cOptional.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
