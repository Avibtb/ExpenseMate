package com.splitwise.service;

import com.splitwise.entity.Roles;
import com.splitwise.entity.Users;
import com.splitwise.enums.RoleEnum;

import java.util.Set;

public interface RoleService {
    Set<Roles> createRole(RoleEnum role,String id);
    Users removeRole(Users users,String id);
    boolean hasPermission(String permission);
}
