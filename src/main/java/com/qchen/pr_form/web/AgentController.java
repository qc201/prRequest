package com.qchen.pr_form.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qchen.pr_form.entity.Agent;
import com.qchen.pr_form.service.AgentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/agent")
public class AgentController {
    AgentService agentService;

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgent(@PathVariable Long id) {
        return new ResponseEntity<>(agentService.getAgent(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Agent> saveAgent(@RequestBody Agent agent) {
        return new ResponseEntity<>(agentService.saveAgent(agent), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Agent>> getAgents() {
        return new ResponseEntity<>(agentService.getAgents(), HttpStatus.OK);
    }

    // /{id}/clitents
    // /{id}/prs
}
