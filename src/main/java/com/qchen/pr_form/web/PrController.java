package com.qchen.pr_form.web;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qchen.pr_form.entity.Pr;
import com.qchen.pr_form.service.PrService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping("/pr")
// pr/{pr.id}/agent/{agent.id}
public class PrController {
    PrService prService;

    @GetMapping("/agent/{agentId}/client/{clientId}/{prId}")
    public ResponseEntity<Pr> getPr(@PathVariable Long prId){
        return new ResponseEntity<>(prService.getPr(prId), HttpStatus.OK);
    }

    @PostMapping("/agent/{agentId}/client/{clientId}")
    public ResponseEntity<Pr> savePr(@PathVariable Long agentId, @PathVariable Long clientId, @RequestBody Pr pr) {
        return new ResponseEntity<>(prService.savePr(pr, agentId, clientId), HttpStatus.OK);
    }

    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Pr>> getPrsByAgentId(@PathVariable Long agentId) {
        return new ResponseEntity<>(prService.getPrsByAgentId(agentId), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Pr>> getPrsByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(prService.getPrsByClientId(clientId), HttpStatus.OK);
    }


    // special auth required
    @PutMapping("/agent/{agentId}/client/{clientId}/{prId}")
    public ResponseEntity<Pr> updatePr(@PathVariable Long agentId, @PathVariable Long clientId, @PathVariable Long prId, @RequestBody Pr pr) {
        return new ResponseEntity<>(prService.updatePr(agentId, clientId, prId, pr), HttpStatus.ACCEPTED);
    }


    // special auth required
    @GetMapping("/all")
    public ResponseEntity<List<Pr>> getAllPrs() {
        return new ResponseEntity<>(prService.getAllPrs(), HttpStatus.OK);
    }

    @DeleteMapping("/agent/{agentId}/client/{clientId}/{prId}")
    public ResponseEntity<HttpStatus> deletePr(@PathVariable Long agentId, @PathVariable Long clientId, @PathVariable Long prId) {
        prService.deletePr(agentId, clientId, prId);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    
    
}
