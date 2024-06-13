package com.backend.backend.Empleados;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    public EmpleadosEntity createEmpleado(EmpleadosEntity empleado)
    {
        return empleadoRepository.save(empleado);
    }

    public ArrayList<EmpleadosEntity> getEmpleados()
    {
        return (ArrayList<EmpleadosEntity>) empleadoRepository.findAll();
    }

    public Optional<EmpleadosEntity> getEmpleadoById(Integer id){
        return empleadoRepository.findById(id);
    }

    public EmpleadosEntity updateEmpleadoById(EmpleadosEntity request, Integer id){
        EmpleadosEntity empleado = empleadoRepository.findById(id).get();
        empleado.setEmpleado_documento(request.getEmpleado_documento());
        empleado.setEmpleado_nombre(request.getEmpleado_nombre());
        empleado.setEmpleado_area(request.getEmpleado_area());
        empleado.setEmpleado_cargo(request.getEmpleado_cargo());
        empleado.setEmpleado_fecha_nacimiento(request.getEmpleado_fecha_nacimiento());
        empleado.setEstado(request.getEstado());

        empleadoRepository.save(empleado);

        return empleado;

    }

}
