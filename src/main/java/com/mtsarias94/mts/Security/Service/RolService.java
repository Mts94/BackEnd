/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mtsarias94.mts.Security.Service;

import com.mtsarias94.mts.Security.Entity.Rol;
import com.mtsarias94.mts.Security.Enums.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtsarias94.mts.Security.Repository.iRolRepository;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
