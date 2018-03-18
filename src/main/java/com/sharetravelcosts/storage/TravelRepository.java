package com.sharetravelcosts.storage;

import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sharetravelcosts.entities.Travel;

public interface TravelRepository extends MongoRepository<Travel, String> {
    public List<Travel> findByDestination(String destination);
    public List<Travel> findByStart(SimpleDateFormat start);
    public List<Travel> findByEnd(SimpleDateFormat end);
    public List<Travel> findByUserId(String userId);
}