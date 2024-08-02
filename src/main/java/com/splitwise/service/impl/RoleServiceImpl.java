package com.splitwise.service.impl;

import com.splitwise.entity.Roles;
import com.splitwise.entity.Users;
import com.splitwise.enums.RoleEnum;
import com.splitwise.repository.RoleRepository;
import com.splitwise.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Set<Roles> createRole(RoleEnum role, String id) {
        role.setObjectId(id);
        return role.getRolesSet().stream().map(r -> Roles.builder().role(r).build()).collect(Collectors.toSet());
    }

    @Override
    public Users removeRole(Users users, String id) {

        // remove that role from roles table

        Set<Roles> roles = users.getRoles().stream().filter(role -> role.getRole().endsWith(id)).collect(Collectors.toSet());
        roleRepository.deleteAllById(
                roles.stream()
                        .map(Roles::getId)
                        .collect(Collectors.toList()));
        users.getRoles().removeAll(roles);

        return users;
    }

    @Override
    public boolean hasPermission(String permission) {
        return roleRepository.existsByRole(permission);
    }
}
