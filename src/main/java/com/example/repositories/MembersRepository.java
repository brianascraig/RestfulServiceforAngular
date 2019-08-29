package com.example.repositories;

import com.example.models.Members;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MembersRepository extends MongoRepository<Members, String> {
    Members findBy_id(ObjectId _id);
    Members removeBy_id(ObjectId id);

}
