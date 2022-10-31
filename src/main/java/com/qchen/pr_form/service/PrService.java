package com.qchen.pr_form.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.qchen.pr_form.entity.Pr;

public interface PrService {
    Pr getPr(Long prId);
    Pr savePr(Pr pr, Long agentId, Long clientId);
    void deletePr( Long agentId, Long clientId, Long prId);
    Pr updatePr( Long agentId, Long clientId, Long prId, JsonPatch jsonPatch) throws JsonParseException, JsonProcessingException, IllegalArgumentException, JsonPatchException;
    List<Pr> getAllPrs();
    List<Pr> getPrsByAgentId(Long agentId);
    List<Pr> getPrsByClientId(Long clientId);
}
