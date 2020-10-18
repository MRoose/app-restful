package com.mroose.apprestful.repository;

import com.mroose.apprestful.model.Summary;
import com.mroose.apprestful.model.SummaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, SummaryId> {

    Summary findByUsername(String username);

    Long deleteByUsername(String username);
}