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
import inacap.webcomponent.prueba4.Model.TipoVehiculoModel;
import inacap.webcomponent.prueba4.Repository.TipoVehiculoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Seba
 */
@RestController
@RequestMapping("/TipoVehiculo")
public class TipoVehiculoController {
    
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;
    
    @GetMapping()
    public Iterable<TipoVehiculoModel> listarTodos() {
        
        return tipoVehiculoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel>muestraTipoVehiculo(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> cOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            TipoVehiculoModel vEncontrado = cOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> editarTipoVehiculo(@PathVariable String id, @RequestBody TipoVehiculoModel tipovehiculoeditar) {
        
        Optional<TipoVehiculoModel> cOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            TipoVehiculoModel cEncontrado = cOptional.get();
            tipovehiculoeditar.setIdTipoVehiculo(cEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(tipovehiculoeditar, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTipoVehiculo(@RequestBody TipoVehiculoModel nuevotipovehiculo) {
        
        nuevotipovehiculo = tipoVehiculoRepository.save(nuevotipovehiculo);
        
        Optional<TipoVehiculoModel> tOptional = tipoVehiculoRepository.findById(nuevotipovehiculo.getIdTipoVehiculo());
        if(tOptional.isPresent()){
            TipoVehiculoModel tEncontrado = tOptional.get();
            return new ResponseEntity<>(tEncontrado, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> cOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
            TipoVehiculoModel tiEncontrado = cOptional.get();
            tipoVehiculoRepository.deleteById(tiEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(tiEncontrado, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
