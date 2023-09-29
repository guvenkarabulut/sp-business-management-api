package com.guvenkarabulut.businessmanagement.service.impl;

import com.guvenkarabulut.businessmanagement.domain.Region;
import com.guvenkarabulut.businessmanagement.repository.RegionRepository;
import com.guvenkarabulut.businessmanagement.service.RegionService;

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
public class RegionServiceImpl implements RegionService {

    private final Logger log = LoggerFactory.getLogger(RegionServiceImpl.class);

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Mono<Region> save(Region region) {
        log.debug("Request to save Region : {}", region);
        return regionRepository.save(region);
    }

    @Override
    public Mono<Region> update(Region region) {
        log.debug("Request to update Region : {}", region);
        return regionRepository.save(region);
    }

    @Override
    public Mono<Region> partialUpdate(Region region) {
        log.debug("Request to partially update Region : {}", region);

        return regionRepository
            .findById(region.getId())
            .map(existingRegion -> {
                if (region.getRegionName() != null) {
                    existingRegion.setRegionName(region.getRegionName());
                }

                return existingRegion;
            })
            .flatMap(regionRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<Region> findAll() {
        log.debug("Request to get all Regions");
        return regionRepository.findAll();
    }

    
    @Transactional(readOnly = true)
    public Flux<Region> findAllWhereCountryIsNull() {
        log.debug("Request to get all regions where Country is null");
        return regionRepository.findAllWhereCountryIsNull();
    }

    public Mono<Long> countAll() {
        return regionRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Region> findOne(Long id) {
        log.debug("Request to get Region : {}", id);
        return regionRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Region : {}", id);
        return regionRepository.deleteById(id);
    }
}
