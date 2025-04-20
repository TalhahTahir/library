package com.talha.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    private String year;
    @NotEmpty
    private String catagory;
    @NotEmpty
    private String file;
    
    @Column(length = 9000)
    private String image;
    
    @Column(length = 500)
    private String description;

    // Manually added setter for id to fix Lombok issue
public void setId(Long id) {
    this.id = id;
}
}
