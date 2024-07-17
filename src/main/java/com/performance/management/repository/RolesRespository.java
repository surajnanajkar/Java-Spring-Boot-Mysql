package com.performance.management.repository;

import com.performance.management.entity.Roles;
import com.performance.management.entity.Usertable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRespository extends JpaRepository<Roles, Integer> {
}
