package com.qchen.pr_form.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qchen.pr_form.entity.Pr;

public interface PrRepository extends CrudRepository<Pr, Long>{
    // custom query: findBy + agent_id 如果需要 後面還可加 And/Or **Id, 這樣就可以take the 2nd parameter
    // the indentifier will look into the column name: agent_id, **_id
    List<Pr> findByAgentId(Long agentId);
    List<Pr> findByClientId(Long clientId);
    
}
