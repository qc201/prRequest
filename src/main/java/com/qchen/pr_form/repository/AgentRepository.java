package com.qchen.pr_form.repository;

import org.springframework.data.repository.CrudRepository;

import com.qchen.pr_form.entity.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long> {
    
}
