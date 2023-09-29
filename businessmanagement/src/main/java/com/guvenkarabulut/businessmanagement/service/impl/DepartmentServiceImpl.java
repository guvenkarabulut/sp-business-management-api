package com.guvenkarabulut.businessmanagement.service.impl;

import com.guvenkarabulut.businessmanagement.domain.Department;
import com.guvenkarabulut.businessmanagement.repository.DepartmentRepository;
import com.guvenkarabulut.businessmanagement.service.DepartmentService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Mono<Department> save(Department department) {
        log.debug("Request to save Department : {}", department);
        return departmentRepository.save(department);
    }

    @Override
    public Mono<Department> update(Department department) {
        log.debug("Request to update Department : {}", department);
        return departmentRepository.save(department);
    }

    @Override
    public Mono<Department> partialUpdate(Department department) {
        log.debug("Request to partially update Department : {}", department);

        return departmentRepository
            .findById(department.getId())
            .map(existingDepartment -> {
                if (department.getDepartmentName() != null) {
                    existingDepartment.setDepartmentName(department.getDepartmentName());
                }

                return existingDepartment;
            })
            .flatMap(departmentRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<Department> findAll() {
        log.debug("Request to get all Departments");
        return departmentRepository.findAll();
    }

    
    @Transactional(readOnly = true)
    public Flux<Department> findAllWhereJobHistoryIsNull() {
        log.debug("Request to get all departments where JobHistory is null");
        return departmentRepository.findAllWhereJobHistoryIsNull();
    }

    public Mono<Long> countAll() {
        return departmentRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Department> findOne(Long id) {
        log.debug("Request to get Department : {}", id);
        return departmentRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Department : {}", id);
        return departmentRepository.deleteById(id);
    }
}
