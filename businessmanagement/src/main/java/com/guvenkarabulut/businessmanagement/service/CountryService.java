package com.guvenkarabulut.businessmanagement.service;

import com.guvenkarabulut.businessmanagement.domain.Country;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CountryService {
    
    Mono<Country> save(Country country);

    
    Mono<Country> update(Country country);

    
    Mono<Country> partialUpdate(Country country);

    
    Flux<Country> findAll();

    
    Flux<Country> findAllWhereLocationIsNull();

    
    Mono<Long> countAll();

    
    Mono<Country> findOne(Long id);

    
    Mono<Void> delete(Long id);
}
