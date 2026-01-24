package com.portfolio.subhashissahu.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Works {
    @Id
    private int id;
    private String tittle;
    private String describtion;
    private String techStack;

    
}
