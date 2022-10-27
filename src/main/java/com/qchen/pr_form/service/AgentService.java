package com.qchen.pr_form.service;

import java.util.List;

import com.qchen.pr_form.entity.Agent;


public interface AgentService {
    Agent getAgent(Long id);
    Agent saveAgent(Agent agent);
    void deleteAgent(Long id);
    List<Agent> getAgents();
    // List<Client> getClients();
    // List<Pr> getPrs();
}
