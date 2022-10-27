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
import org.springframework.web.bind.annotation.RequestParam;



@AllArgsConstructor
@RestController
@RequestMapping("/pr")
// pr/{pr.id}/agent/{agent.id}
public class PrController {
    PrService prService;

    @GetMapping("/{prId}")
    public ResponseEntity<Pr> getPr(@PathVariable Long prId){
        return new ResponseEntity<>(prService.getPr(prId), HttpStatus.OK);
    }

    @PostMapping("/agent/{agentId}")
    public ResponseEntity<Pr> savePr(@RequestBody Pr pr, @PathVariable Long agentId) {
        return new ResponseEntity<>(prService.savePr(pr, agentId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{prId}")
    public ResponseEntity<HttpStatus> deletePr(@PathVariable Long prId) {
        prService.deletePr(prId);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pr>> getPrs() {
        return new ResponseEntity<>(prService.getAllPrs(), HttpStatus.OK);
    }

    @PutMapping("/agent/{agentId}/prid/{prId}")
    public ResponseEntity<Pr> updatePr(@PathVariable Long agentId, @PathVariable Long prId, @RequestBody Pr pr ) {
        return new ResponseEntity<>(prService.updatePr(agentId, prId, pr), HttpStatus.OK);
    }

    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Pr>> getPrsByAgentId(@PathVariable Long agentId) {
        return new ResponseEntity<>(prService.getPrsByAgentId(agentId), HttpStatus.OK);
    }
    
}
