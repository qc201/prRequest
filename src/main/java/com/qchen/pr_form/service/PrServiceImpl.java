package com.qchen.pr_form.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;
import com.qchen.pr_form.entity.Agent;
import com.qchen.pr_form.entity.Client;
import com.qchen.pr_form.entity.Pr;
import com.qchen.pr_form.repository.AgentRepository;
import com.qchen.pr_form.repository.ClientRepository;
import com.qchen.pr_form.repository.PrRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrServiceImpl implements PrService {
    PrRepository prRepository;
    AgentRepository agentRepository;
    ClientRepository clientRepository;

    @Override
    public Pr getPr( Long prId) {
        return prRepository.findById(prId).get();
    }

    @Override
    public Pr savePr(Pr pr, Long agentId, Long clientId) {
        Agent agent = agentRepository.findById(agentId).get();
        Client client = clientRepository.findById(clientId).get();
        pr.setAgent(agent);
        pr.setClient(client);
        LocalDate created = LocalDate.now();
        pr.setCreateDate(created);
        return prRepository.save(pr);
    }

    // update pr require special authorization
    @Override
    public Pr updatePr(Long agentId, Long clientId, Long prId, Pr pr) {
        Pr prevPr = getPr(prId);
        prevPr.setCostCode(pr.getCostCode());
        prevPr.setReporter(pr.getReporter());
        prevPr.setStatusCode(pr.getStatusCode());
        return prRepository.save(prevPr);   
    }

    // delete pr require special authorization
    @Override
    public void deletePr(Long agentId, Long clientId, Long prId) {
        prRepository.deleteById(prId);
    }

    @Override
    public List<Pr> getPrsByAgentId(Long agentId) {
        return prRepository.findByAgentId(agentId);
    }

    @Override
    public List<Pr> getPrsByClientId(Long clientId) {
        return prRepository.findByClientId(clientId);
    }

    @Override
    public List<Pr> getAllPrs() {
        return (List<Pr>)prRepository.findAll();
    }
}
