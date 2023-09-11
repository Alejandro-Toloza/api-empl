package com.neoris.turnosrotativos.service;

import com.neoris.turnosrotativos.dto.EmpleadoDTO;
import com.neoris.turnosrotativos.entities.Empleado;

import java.util.List;

public interface EmpleadoService {

        public Empleado getEmpleado(Long id);

        public List<Empleado> getEmpleados();

        public Empleado addEmpleado(Empleado emp);

        public Empleado updateEmpleado(EmpleadoDTO emp, Long id);

}
