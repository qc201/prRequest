package com.qchen.pr_form.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Table(name = "reporter")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class Reporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;
}
