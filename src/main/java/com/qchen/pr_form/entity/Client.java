package com.qchen.pr_form.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;


@Table(name = "client")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotBlank(message = "the name of the company cannot be blank")
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;


    @NotNull
    @Column(name = "budget", nullable = false)
    private Double budget;

    // many to one relationship: 一個agent可以有很多個client 所以我們把foreign key放在many裏

}
