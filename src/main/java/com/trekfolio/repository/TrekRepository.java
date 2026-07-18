package com.trekfolio.repository;

import com.trekfolio.entity.Trek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrekRepository extends JpaRepository<Trek, Long> {

}