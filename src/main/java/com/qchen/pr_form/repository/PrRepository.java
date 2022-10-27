package com.qchen.pr_form.repository;

import org.springframework.data.repository.CrudRepository;

import com.qchen.pr_form.entity.Pr;

public interface PrRepository extends CrudRepository<Pr, Long>{
    
}
