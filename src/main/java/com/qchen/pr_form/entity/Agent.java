package com.qchen.pr_form.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

// spicify name of the table
@Table(name = "agent")
// create table
@Entity 

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @NotBlank
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "agent") 
    private List<Pr> prs;

    @JsonIgnore
    @OneToMany(mappedBy = "agent")
    private List<Client> clients;
}
