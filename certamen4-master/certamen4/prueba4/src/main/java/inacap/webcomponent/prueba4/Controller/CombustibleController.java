/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Controller;

import inacap.webcomponent.prueba4.Model.CombustibleModel;
import inacap.webcomponent.prueba4.Repository.CombustibleRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/url")
public class CombustibleController {

    @Autowired
    private CombustibleRepository combustibleRepository;

    @GetMapping()
    public Iterable<CombustibleModel> listarTodos() {

        return combustibleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombustibleModel> muestracombustibles(@PathVariable String id) {

        Optional<CombustibleModel> cOptional = combustibleRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {
            return new ResponseEntity(cOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> editarcombustible(@PathVariable String id, @RequestBody CombustibleModel CombustibleEditar) {

        Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            CombustibleModel cEncontrado = aOptional.get();

            CombustibleEditar.setIdCombustible(cEncontrado.getIdCombustible());

            combustibleRepository.save(CombustibleEditar);

            return new ResponseEntity<>(CombustibleEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarCombustible(@RequestBody CombustibleModel nuevoCombustible) {

        nuevoCombustible = combustibleRepository.save(nuevoCombustible);

        Optional<CombustibleModel> cOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());

        if (cOptional.isPresent()) {
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<CombustibleModel> cOptional = combustibleRepository.findById(Integer.parseInt(id));

        if (cOptional.isPresent()) {

            combustibleRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(cOptional.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
