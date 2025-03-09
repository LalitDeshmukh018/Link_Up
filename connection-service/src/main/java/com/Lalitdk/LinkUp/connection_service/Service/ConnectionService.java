package com.Lalitdk.LinkUp.connection_service.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Lalitdk.LinkUp.connection_service.Entity.Person;
import com.Lalitdk.LinkUp.connection_service.Repository.PersonRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConnectionService {

    private final PersonRepository personRespository;

    public List<Person> getFirstDegreeConnections(Long userId) {
        log.info("Getting first degree connections for user with id: {}", userId);
        return personRespository.getFirstDegreeConnection(userId);
    }
}
