package com.example.restfulservice.repositories;

import com.example.restfulservice.models.Members;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MembersRepository extends MongoRepository<Members, String> {
    Members findBy_id(ObjectId _id);
    Members removeBy_id(ObjectId id);

}
