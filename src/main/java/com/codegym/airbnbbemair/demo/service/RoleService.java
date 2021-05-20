package com.codegym.airbnbbemair.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface RoleService extends GeneralService{
    void setDefaulRole(int userId, Long roleId);
}
