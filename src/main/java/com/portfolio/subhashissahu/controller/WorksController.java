package com.portfolio.subhashissahu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.portfolio.subhashissahu.model.Works;
import com.portfolio.subhashissahu.service.WorksService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping
public class WorksController {

    private final WorksService worksService;

    public WorksController(WorksService worksService) {
        this.worksService = worksService;
    }

    @GetMapping("/public/works")
    public ResponseEntity<List<Works>> getAllWorks() {
        return worksService.getAllWorks();
    }

    @GetMapping("/public/works/{id}")
    public ResponseEntity<Works> getWorksById(@PathVariable int id) {
        return worksService.getWorksById(id);
    }

    @PostMapping("/admin/works")
    public ResponseEntity<String> addWorks(@RequestBody Works work) {
        return worksService.addWorks(work);
    }

    @DeleteMapping("/admin/works/{id}")
    public ResponseEntity<String> deleteWorkById(@PathVariable int id) {
        return worksService.deleteWorkById(id);
    }

    @GetMapping("/admin/check")
    public ResponseEntity<?> checkAuth() {
        return ResponseEntity.ok().build();
    }

}
