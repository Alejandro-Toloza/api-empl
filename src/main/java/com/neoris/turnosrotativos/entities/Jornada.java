package com.neoris.turnosrotativos.entities;

import java.time.LocalDate;

public class Jornada {


    private Integer idEmpleado;
    private Integer idConcepto;
    private LocalDate fecha;


    //Solamente no es requerido para el concepto "Día Libre".
    private Integer horasTrabajadas;


}
