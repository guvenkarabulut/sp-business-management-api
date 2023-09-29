package com.guvenkarabulut.businessmanagement.service;

import java.util.List;

import com.guvenkarabulut.businessmanagement.domain.Department;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface DepartmentService {
    
    Mono<Department> save(Department department);

    
    Mono<Department> update(Department department);

    
    Mono<Department> partialUpdate(Department department);

    
    Flux<Department> findAll();

    
    Flux<Department> findAllWhereJobHistoryIsNull();

    
    Mono<Long> countAll();

    
    Mono<Department> findOne(Long id);

    
    Mono<Void> delete(Long id);
}
