package com.qchen.pr_form.service;

import java.util.List;

import com.qchen.pr_form.entity.Pr;

public interface PrService {
    Pr getPr(Long id);
    Pr savePr(Pr pr, Long agentId);
    void deletePr(Long id);
    Pr updatePr(Long agentId, Long prId, Pr pr);
    List<Pr> getAllPrs();
    List<Pr> getPrsByAgentId(Long agentId);
}
