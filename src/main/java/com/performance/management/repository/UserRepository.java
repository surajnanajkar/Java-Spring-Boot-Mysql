package com.performance.management.repository;

import com.performance.management.entity.Usertable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usertable, Integer>{
    Optional<Object> findByEmail(String email);

    Optional<Object> findByPhoneNumber(String phoneNumber);

    Optional<Object> findByEmpId(String empId);
}
