package com.bcts.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BirdRepository extends MongoRepository<Bird, String> {
    
}
