package com.lamaryw.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lamaryw.web.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
