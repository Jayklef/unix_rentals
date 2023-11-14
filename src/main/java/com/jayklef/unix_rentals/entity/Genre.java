package com.jayklef.unix_rentals.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        name = "genre",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.PERSIST)
    private List<Movie> movies;
}
