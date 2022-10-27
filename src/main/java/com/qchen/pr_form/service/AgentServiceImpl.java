package com.qchen.pr_form.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qchen.pr_form.entity.Agent;
import com.qchen.pr_form.repository.AgentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class AgentServiceImpl implements AgentService {
    AgentRepository agentRepository;

    @Override
    public Agent getAgent(Long id) {
        return agentRepository.findById(id).get();
    }

    @Override
    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }

    @Override
    public List<Agent> getAgents() {
        return (List<Agent>)agentRepository.findAll();
    }
}
