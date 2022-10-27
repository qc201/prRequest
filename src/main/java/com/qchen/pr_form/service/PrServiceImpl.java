package com.qchen.pr_form.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qchen.pr_form.entity.Agent;
import com.qchen.pr_form.entity.Pr;
import com.qchen.pr_form.repository.PrRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrServiceImpl implements PrService {
    PrRepository prRepository;
    AgentService agentService;

    @Override
    public Pr getPr(Long id) {
        return prRepository.findById(id).get();
    }

    @Override
    public Pr savePr(Pr pr, Long agentId) {
        Agent agent = agentService.getAgent(agentId);
        pr.setAgent(agent);
        LocalDate dateObj = LocalDate.now();
        pr.setCreateDate(dateObj);
        return prRepository.save(pr);
    }

    @Override
    public Pr updatePr(Long agentId, Long prId, Pr pr) {
        Pr prevPr = prRepository.findById(prId).get();
        LocalDate prevDate = prevPr.getCreateDate();
        Long prevId = prevPr.getId();
        Agent agent = agentService.getAgent(agentId);
        if (prevPr.getAgent().getId() == agent.getId()) {
            pr.setAgent(agent);
            pr.setCreateDate(prevDate);
            pr.setId(prevId);
            return prRepository.save(pr);
        }
        return pr;
    }

    @Override
    public void deletePr(Long id) {
        prRepository.deleteById(id);
        
    }

    @Override
    public List<Pr> getAllPrs() {
        return (List<Pr>) prRepository.findAll();
    }

    @Override
    public List<Pr> getPrsByAgentId(Long agentId) {
        return (List<Pr>) prRepository.findByAgentId(agentId);
    }
}
