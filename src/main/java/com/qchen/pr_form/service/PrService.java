package com.qchen.pr_form.service;

import java.util.List;


import com.qchen.pr_form.entity.Pr;

public interface PrService {
    Pr getPr(Long prId);
    Pr savePr(Pr pr, Long agentId, Long clientId);
    void deletePr( Long agentId, Long clientId, Long prId);
    Pr updatePr(Long agentId, Long clientId, Long prId, Pr pr);
    List<Pr> getAllPrs();
    List<Pr> getPrsByAgentId(Long agentId);
    List<Pr> getPrsByClientId(Long clientId);
}
