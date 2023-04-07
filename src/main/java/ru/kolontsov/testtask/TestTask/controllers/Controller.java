package ru.kolontsov.testtask.TestTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.services.Services;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Controller {

    private final Services services;

    @Autowired
    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping
    public String showMessage() {
        return "my proj";
    }

    @GetMapping("/find")
    public void showAll() {
        services.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TypeEntity> findTypeById(@PathVariable("id") Long id) {
        return services.findById(id);
    }


    @GetMapping("/{name}")
    public List<TypeEntity> showModelsByType(@PathVariable("name") String name) {
        return services.getTypeByName(name);
    }

}
