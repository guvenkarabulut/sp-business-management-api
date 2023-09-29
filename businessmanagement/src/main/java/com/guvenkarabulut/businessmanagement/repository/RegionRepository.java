package com.guvenkarabulut.businessmanagement.repository;

import com.guvenkarabulut.businessmanagement.domain.Region;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@SuppressWarnings("unused")
@Repository
public interface RegionRepository extends ReactiveCrudRepository<Region, Long>, RegionRepositoryInternal {
    @Query("SELECT * FROM region entity WHERE entity.id not in (select country_id from country)")
    Flux<Region> findAllWhereCountryIsNull();

    @Override
    <S extends Region> Mono<S> save(S entity);

    @Override
    Flux<Region> findAll();

    @Override
    Mono<Region> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface RegionRepositoryInternal {
    <S extends Region> Mono<S> save(S entity);

    Flux<Region> findAllBy(Pageable pageable);

    Flux<Region> findAll();

    Mono<Region> findById(Long id);

}
