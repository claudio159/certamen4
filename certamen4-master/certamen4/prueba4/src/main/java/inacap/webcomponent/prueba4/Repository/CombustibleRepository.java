/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.prueba4.Model.CombustibleModel;
/**
 *
 * @author Seba
 */
public interface CombustibleRepository extends CrudRepository<CombustibleModel, Integer> {
    
}
