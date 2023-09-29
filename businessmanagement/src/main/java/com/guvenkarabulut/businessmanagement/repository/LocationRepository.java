package com.guvenkarabulut.businessmanagement.repository;

import com.guvenkarabulut.businessmanagement.domain.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@SuppressWarnings("unused")
@Repository
public interface LocationRepository extends ReactiveCrudRepository<Location, Long>, LocationRepositoryInternal {
    @Query("SELECT * FROM location entity WHERE entity.country_id = :id")
    Flux<Location> findByCountry(Long id);

    @Query("SELECT * FROM location entity WHERE entity.country_id IS NULL")
    Flux<Location> findAllWhereCountryIsNull();

    @Query("SELECT * FROM location entity WHERE entity.id not in (select department_id from department)")
    Flux<Location> findAllWhereDepartmentIsNull();

    @Override
    <S extends Location> Mono<S> save(S entity);

    @Override
    Flux<Location> findAll();

    @Override
    Mono<Location> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface LocationRepositoryInternal {
    <S extends Location> Mono<S> save(S entity);

    Flux<Location> findAllBy(Pageable pageable);

    Flux<Location> findAll();

    Mono<Location> findById(Long id);

}
