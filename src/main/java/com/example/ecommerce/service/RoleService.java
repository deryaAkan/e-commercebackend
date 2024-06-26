package com.example.ecommerce.service;

import com.example.ecommerce.entity.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role saveRole(Role role);
    Optional<Role> getRoleById(Long id);
    List<Role> getAllRoles();
    void deleteRole(Long id);
}
