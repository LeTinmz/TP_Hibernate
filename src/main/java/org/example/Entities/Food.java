package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name="Food")
public class Food extends Article {
    private LocalDate expiryDate;
}
