package com.guvenkarabulut.businessmanagement.service;

import com.guvenkarabulut.businessmanagement.domain.Location;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface LocationService {
    
    Mono<Location> save(Location location);

    
    Mono<Location> update(Location location);

    
    Mono<Location> partialUpdate(Location location);

    
    Flux<Location> findAll();

    
    Flux<Location> findAllWhereDepartmentIsNull();

    
    Mono<Long> countAll();

    
    Mono<Location> findOne(Long id);

    
    Mono<Void> delete(Long id);
}
