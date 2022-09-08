package com.raiseup.smrs.api.repository;

import com.raiseup.smrs.api.web.model.BeerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<BeerDto,Long> {
}
