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

import com.qchen.pr_form.entity.Client;
import com.qchen.pr_form.service.ClientService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return new ResponseEntity<Client>(clientService.getClient(id), HttpStatus.OK);
    }

    @PostMapping("/agent/{agentId}")
    public ResponseEntity<Client> saveClient(@RequestBody Client client, @PathVariable Long agentId) {
        return new ResponseEntity<Client>(clientService.saveClient(client, agentId), HttpStatus.ACCEPTED);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

}
