package com.qchen.pr_form.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;


    // many to one relationship: 一個agent可以有很多個client 所以我們把foreign key放在many裏
    // one client associated with many prs
    //do not create any join table
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Pr> prs;
}
