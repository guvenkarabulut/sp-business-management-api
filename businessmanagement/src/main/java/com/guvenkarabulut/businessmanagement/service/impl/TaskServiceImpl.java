package com.guvenkarabulut.businessmanagement.service.impl;

import com.guvenkarabulut.businessmanagement.domain.Task;
import com.guvenkarabulut.businessmanagement.repository.TaskRepository;
import com.guvenkarabulut.businessmanagement.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Mono<Task> save(Task task) {
        log.debug("Request to save Task : {}", task);
        return taskRepository.save(task);
    }

    @Override
    public Mono<Task> update(Task task) {
        log.debug("Request to update Task : {}", task);
        return taskRepository.save(task);
    }

    @Override
    public Mono<Task> partialUpdate(Task task) {
        log.debug("Request to partially update Task : {}", task);

        return taskRepository
            .findById(task.getId())
            .map(existingTask -> {
                if (task.getTitle() != null) {
                    existingTask.setTitle(task.getTitle());
                }
                if (task.getDescription() != null) {
                    existingTask.setDescription(task.getDescription());
                }

                return existingTask;
            })
            .flatMap(taskRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<Task> findAll() {
        log.debug("Request to get all Tasks");
        return taskRepository.findAll();
    }

    public Mono<Long> countAll() {
        return taskRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Task> findOne(Long id) {
        log.debug("Request to get Task : {}", id);
        return taskRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Task : {}", id);
        return taskRepository.deleteById(id);
    }
}
