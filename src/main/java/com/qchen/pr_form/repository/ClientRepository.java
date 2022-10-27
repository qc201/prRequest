package com.qchen.pr_form.repository;

import org.springframework.data.repository.CrudRepository;

import com.qchen.pr_form.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{
    
}
