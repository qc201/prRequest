package com.qchen.pr_form.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qchen.pr_form.entity.Client;
import com.qchen.pr_form.repository.ClientRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{
    ClientRepository clientRepository;

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }
}
