package com.guvenkarabulut.businessmanagement.service;

import java.util.List;

import com.guvenkarabulut.businessmanagement.domain.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TaskService {
    
    Mono<Task> save(Task task);

    
    Mono<Task> update(Task task);

    
    Mono<Task> partialUpdate(Task task);

    
    Flux<Task> findAll();

    
    Mono<Long> countAll();

    
    Mono<Task> findOne(Long id);

    
    Mono<Void> delete(Long id);
}
