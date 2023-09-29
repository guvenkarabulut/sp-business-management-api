package com.guvenkarabulut.businessmanagement.service;

import com.guvenkarabulut.businessmanagement.domain.JobHistory;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface JobHistoryService {
    
    Mono<JobHistory> save(JobHistory jobHistory);

    
    Mono<JobHistory> update(JobHistory jobHistory);

    
    Mono<JobHistory> partialUpdate(JobHistory jobHistory);

    
    Flux<JobHistory> findAll(Pageable pageable);

    
    Mono<Long> countAll();

    
    Mono<JobHistory> findOne(Long id);

    
    Mono<Void> delete(Long id);
}
