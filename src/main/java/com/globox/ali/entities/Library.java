package com.globox.ali.entities;


import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Getter
@Setter
public class Library extends BaseEntity {
    private String name;
}
