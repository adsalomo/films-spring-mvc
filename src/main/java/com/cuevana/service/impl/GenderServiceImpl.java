package com.cuevana.service.impl;

import com.cuevana.model.Gender;
import com.cuevana.repository.GenderRepository;
import com.cuevana.service.iface.GenderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion servicio gender
 * Esta clase implementa los metodos de la interfaz genderService
 * Ademas se le agrega la anotacion @Service para indicar al contexto de spring que es un componente de sprint
 * @author adrian
 */
@Service
public class GenderServiceImpl implements GenderService {

    // A traves de inyeccion de dependencias, inyectamos el componente de repository
    @Autowired
    private GenderRepository genderRepository;
    
    @Override
    public List<Gender> getAll() {
        List<Gender> genders = new ArrayList<>();
        this.genderRepository.findAll().forEach(genders::add);
        return genders;
    }
    
}
