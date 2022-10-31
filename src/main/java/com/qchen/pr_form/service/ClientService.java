package com.qchen.pr_form.service;

import java.util.List;

import com.qchen.pr_form.entity.Client;

public interface ClientService {
    Client getClient(Long id);
    Client saveClient(Client client, Long agentId);
    void deleteClient(Long id);
    List<Client> getClients();
    
}
