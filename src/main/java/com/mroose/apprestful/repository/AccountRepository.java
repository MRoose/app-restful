package com.mroose.apprestful.repository;

import com.mroose.apprestful.model.Account;
import com.mroose.apprestful.model.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountId> {

    Account findByUsername(String username);

    Long deleteByUsername(String username);
}