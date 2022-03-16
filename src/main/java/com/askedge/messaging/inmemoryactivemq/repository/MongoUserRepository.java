package com.askedge.messaging.inmemoryactivemq.repository;

import com.askedge.messaging.inmemoryactivemq.model.MongoUserResource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUserResource, Long> {


}
