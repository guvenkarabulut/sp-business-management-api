package com.guvenkarabulut.businessmanagement.service;

import java.util.List;

import com.guvenkarabulut.businessmanagement.domain.Region;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface RegionService {
    
    Mono<Region> save(Region region);

    
    Mono<Region> update(Region region);

    
    Mono<Region> partialUpdate(Region region);

    
    Flux<Region> findAll();

    
    Flux<Region> findAllWhereCountryIsNull();

    
    Mono<Long> countAll();

    
    Mono<Region> findOne(Long id);

    
    Mono<Void> delete(Long id);
}
