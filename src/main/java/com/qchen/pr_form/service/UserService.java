package com.qchen.pr_form.service;

import com.qchen.pr_form.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
    
}
