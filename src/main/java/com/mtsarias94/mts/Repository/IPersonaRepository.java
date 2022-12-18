/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mtsarias94.mts.Repository;

import com.mtsarias94.mts.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 *
 * @author matia
 */
public interface IPersonaRepository extends JpaRepository<Persona, Integer>  {
     public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
