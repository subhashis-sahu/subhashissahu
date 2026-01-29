package com.portfolio.subhashissahu.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.portfolio.subhashissahu.model.Works;
import com.portfolio.subhashissahu.repo.WorksRepo;

@Service
public class WorksService {

    private final WorksRepo worksRepo;

    public WorksService(WorksRepo worksRepo) {
        this.worksRepo = worksRepo;
    }

    public ResponseEntity<List<Works>> getAllWorks() {
        return ResponseEntity.ok(worksRepo.findAll());
    }

    public ResponseEntity<Works> getWorksById(int id) {
        Works works = worksRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Work not found"));
        return ResponseEntity.ok(works);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<String> addWorks(Works work) {
    //     worksRepo.save(work);
    //     return ResponseEntity
    //             .status(HttpStatus.CREATED)
    //             .body("Work added successfully");
    // }

    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<String> deleteWorkById(int id) {

    //     if (!worksRepo.existsById(id)) {
    //         throw new RuntimeException("Work not found");
    //     }

    //     worksRepo.deleteById(id);
    //     return ResponseEntity.noContent().build();
    // }
}
