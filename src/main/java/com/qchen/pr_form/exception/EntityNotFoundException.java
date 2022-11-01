package com.qchen.pr_form.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id, Class<?> entity) {
        super("The" + entity.getSimpleName().toLowerCase() + "with id " + id + "does NOT exist.");
    }
    
}
