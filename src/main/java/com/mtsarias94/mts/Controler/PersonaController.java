
package com.mtsarias94.mts.Controler;

import com.mtsarias94.mts.Dto.dtoPersona;
import com.mtsarias94.mts.Entity.Persona;
import com.mtsarias94.mts.Security.Controller.Mensaje;
import com.mtsarias94.mts.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")

@CrossOrigin(origins = "https://mts94-6c445.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

   @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.save(persona);
        return "La persona fue creada correctamente";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopers) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByNombre(dtopers.getNombre()) && personaService.getByNombre(dtopers.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopers.getNombre());
        persona.setApellido(dtopers.getApellido());
        persona.setDescripcion(dtopers.getDescripcion());
        persona.setImg(dtopers.getImg());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }*/
}