package com.guvenkarabulut.businessmanagement.repository;

import com.guvenkarabulut.businessmanagement.domain.Authority;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AuthorityRepository extends R2dbcRepository<Authority, String> {}
