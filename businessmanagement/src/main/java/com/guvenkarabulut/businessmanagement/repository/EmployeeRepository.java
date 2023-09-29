package com.guvenkarabulut.businessmanagement.repository;

import com.guvenkarabulut.businessmanagement.domain.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long>, EmployeeRepositoryInternal {
    Flux<Employee> findAllBy(Pageable pageable);

    @Query("SELECT * FROM employee entity WHERE entity.manager_id = :id")
    Flux<Employee> findByManager(Long id);

    @Query("SELECT * FROM employee entity WHERE entity.manager_id IS NULL")
    Flux<Employee> findAllWhereManagerIsNull();

    @Query("SELECT * FROM employee entity WHERE entity.department_id = :id")
    Flux<Employee> findByDepartment(Long id);

    @Query("SELECT * FROM employee entity WHERE entity.department_id IS NULL")
    Flux<Employee> findAllWhereDepartmentIsNull();

    @Query("SELECT * FROM employee entity WHERE entity.id not in (select job_history_id from job_history)")
    Flux<Employee> findAllWhereJobHistoryIsNull();

    @Override
    <S extends Employee> Mono<S> save(S entity);

    @Override
    Flux<Employee> findAll();

    @Override
    Mono<Employee> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface EmployeeRepositoryInternal {
    <S extends Employee> Mono<S> save(S entity);

    Flux<Employee> findAllBy(Pageable pageable);

    Flux<Employee> findAll();

    Mono<Employee> findById(Long id);

}
