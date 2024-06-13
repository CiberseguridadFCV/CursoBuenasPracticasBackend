package com.backend.backend.Empleados;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/empleado")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5000"})
public class EmpleadosController {

    private final EmpleadoService empleadoService;

    @PostMapping("/crear")
    public EmpleadosEntity createEmpleado(@RequestBody EmpleadosEntity empleado)
    {
       return this.empleadoService.createEmpleado(empleado);
    }

    @GetMapping("/listar")
    public ArrayList<EmpleadosEntity> getEmpleados()
    {
        return this.empleadoService.getEmpleados();
    }

    @GetMapping("/listar/{id}")
    public Optional<EmpleadosEntity> getEmpeladoById(@PathVariable Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }

    @PutMapping("/editar/{id}")
    public EmpleadosEntity updateEmpleadoById(@RequestBody EmpleadosEntity request, @PathVariable Integer id){
        return this.empleadoService.updateEmpleadoById(request, id);
    }



}
