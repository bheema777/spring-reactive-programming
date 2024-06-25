package com.honeybadger.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Student> save(@RequestBody Student student){
        return service.save(student);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Student> findAll(){
        return  service.findAll();
    }

    @GetMapping("/{id}")
    Mono<Student> findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }


}
