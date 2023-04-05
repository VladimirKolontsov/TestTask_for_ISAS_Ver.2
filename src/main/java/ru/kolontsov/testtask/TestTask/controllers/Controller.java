package ru.kolontsov.testtask.TestTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.services.Service;

import java.util.List;

@RestController
@RequestMapping("/cont")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public String showMessage() {
        return "my proj";
    }

    @GetMapping("/{name}")
    public List<ModelEntity> showModelsByType(@PathVariable("name") String name) {
        return service.getTypeByName(name);
    }

}
