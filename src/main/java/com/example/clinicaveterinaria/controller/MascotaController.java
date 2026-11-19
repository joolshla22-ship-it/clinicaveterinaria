package com.example.clinicaveterinaria.controller;

import com.example.clinicaveterinaria.model.Mascota;
import com.example.clinicaveterinaria.service.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;


    @GetMapping
    public List<Mascota> getMascotas() {
        return mascotaService.findAll();
    }

    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.findById(id);
    }


    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.save(mascota);
    }


    @PutMapping("/{id}")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota existingMascota = mascotaService.findById(id);
        if (existingMascota != null) {
            mascota.setId(id);
            return mascotaService.save(mascota);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteById(id);
    }
}
