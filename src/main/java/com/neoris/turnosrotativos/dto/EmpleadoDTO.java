package com.neoris.turnosrotativos.dto;

import com.neoris.turnosrotativos.entities.Empleado;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Component
public class EmpleadoDTO {

    private Integer id;
    private Integer nro_documento;

    @NotNull(message = "firstname no puede ser nulo")
    @NotBlank(message = "firstname no puede ser vacío")
    private String nombre;
    private String apellido;
    private String email;
    private Date fecha_nacimiento;
    private Date fecha_ingreso;
    private Date fecha_creacion;

    public Empleado toEntity() {
        Empleado entity = new Empleado();

        entity.setId(this.id);
        entity.setApellido(this.apellido);
        entity.setNombre(this.nombre);
        entity.setEmail(this.email);
        entity.setNro_documento(this.nro_documento);
        entity.setFecha_creacion(this.fecha_creacion);
        entity.setFecha_ingreso(this.fecha_ingreso);
        entity.setFecha_nacimiento(this.fecha_nacimiento);

        return entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(Integer nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
