package com.example.springboot.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springboot.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> { }