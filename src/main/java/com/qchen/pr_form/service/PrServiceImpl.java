package com.qchen.pr_form.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.type.LocalDateType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
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

    @Override
    public Pr updatePr(Long agentId, Long clientId, Long prId, JsonPatch jsonPatch)
            throws JsonParseException, JsonProcessingException, IllegalArgumentException, JsonPatchException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletePr(Long agentId, Long clientId, Long prId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Pr> getPrsByAgentId(Long agentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Pr> getPrsByClientId(Long clientId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Pr> getAllPrs() {
        // TODO Auto-generated method stub
        return null;
    }
}
