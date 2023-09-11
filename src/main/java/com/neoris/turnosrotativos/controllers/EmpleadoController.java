package com.neoris.turnosrotativos.controllers;

import com.neoris.turnosrotativos.dto.EmpleadoDTO;
import com.neoris.turnosrotativos.entities.Empleado;
import com.neoris.turnosrotativos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("apiempleados")
public class EmpleadoController{

    @Autowired
    EmpleadoService empleadoService;

    //@GetMapping("/students")
    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public ResponseEntity<List<Empleado>> getStudents() {
        return ResponseEntity.ok(this.empleadoService.getEmpleados());
        //return new ResponseEntity<>(this.studentService.getStudents(), HttpStatus.OK);
    }


    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getStudent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.empleadoService.getEmpleado(id));
        //return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping("/empleados")
    public ResponseEntity<Empleado> addStudent(@Valid @RequestBody Empleado emp) {
        Empleado empAdded = this.empleadoService.addEmpleado(emp);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.LOCATION, String.format("/students/%d", empAdded.getId()));
        return ResponseEntity.created(URI
                        .create(String.format("/students/%d", empAdded.getId())))
                .body(empAdded);
        //return new ResponseEntity<Student>(studentAdded, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable("id") Long id,
                                                @Valid @RequestBody EmpleadoDTO empDTO) {
        Empleado studentMod = this.empleadoService.updateEmpleado(empDTO, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}