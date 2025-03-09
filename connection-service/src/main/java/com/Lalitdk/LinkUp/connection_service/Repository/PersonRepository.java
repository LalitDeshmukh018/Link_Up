package com.Lalitdk.LinkUp.connection_service.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.Lalitdk.LinkUp.connection_service.Entity.Person;
import java.util.Optional;
import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Optional<Person> getByName(String name);

@Query("MATCH (p:Person)-[:CONNECTED_TO {degree: 1}]->(q:Person) WHERE p.userId = $userId RETURN q")
    List<Person> getFirstDegreeConnection(Long userId);
}
