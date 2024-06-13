package com.backend.backend.Empleados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class EmpleadosEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String empleado_documento;
    private String empleado_nombre;
    private String empleado_area;
    private String empleado_cargo;
    private String empleado_fecha_nacimiento;
    private String estado = "Activo";


}
