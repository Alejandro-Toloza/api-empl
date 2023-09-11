package com.neoris.turnosrotativos.service.impl;

import com.neoris.turnosrotativos.dto.EmpleadoDTO;
import com.neoris.turnosrotativos.entities.Empleado;
import com.neoris.turnosrotativos.repository.EmpleadoRepository;
import com.neoris.turnosrotativos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neoris.turnosrotativos.exceptions.BussinessException;


import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository repository;


    @Override
    public Empleado getEmpleado(Long id) {
        Optional<Empleado> student = repository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Empleado> getEmpleados() {
        return repository.findAll();
    }

    @Override
    public Empleado addEmpleado(Empleado emp) {
        Optional<Empleado> studentOptional =
                repository.findByEmail(emp.getEmail());

        if (studentOptional.isPresent()) {
            throw new BussinessException("El email con el que " +
                    "desea crear el empleado ya se encuentra en uso");
        } else {
            Empleado empAdded = repository.save(emp);
            return empAdded;
        }
    }

    @Override
    public Empleado updateEmpleado(EmpleadoDTO emp, Long id) {
        Optional<Empleado> empFind = repository.findById(id);

        if (empFind.isPresent()) {
            emp.setId(empFind.get().getId());
            return repository.save(emp.toEntity());
        } else {
            throw new BussinessException("El id que quiere modificar no existe");
        }
    }
}
