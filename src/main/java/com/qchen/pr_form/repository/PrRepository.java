package com.qchen.pr_form.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qchen.pr_form.entity.Pr;

public interface PrRepository extends CrudRepository<Pr, Long>{
    // custom query: findBy + agent_id 
    List<Pr> findByAgentId(Long agentId);
    
}
