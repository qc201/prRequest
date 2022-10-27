package com.qchen.pr_form.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.*;

@Table(name = "pr")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;

    // 確保這部分的變量是可以更改的
    @Column(name = "status_code", nullable = false)
    private int statusCode;

    @Column(name = "cost_code", nullable = false)
    private int costCode;

    // 因為這部分的內容我們無法通過path variable來獲得，我們需要通過form輸入來加入到裡面
    @Column(name = "reporter", nullable = false)
    private String reporter;
    
    // pr/agent/{agent.id}/client/{client.id}/{pr.id}
    // pr/{pr.id}/agent/{agent.id}
    // one agent can have many prs, so the pr is the child table, the foreign key will inject in child table

    //many prs will be associated with one agent, and this is one directional
    @ManyToOne(optional = false)
    // the primary key in the parent table is id
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;

    
    
}
