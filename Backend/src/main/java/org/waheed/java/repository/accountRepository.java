package org.waheed.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.waheed.java.model.account;

public interface accountRepository extends JpaRepository<account,Long> {
    
}
