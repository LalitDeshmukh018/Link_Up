package com.Lalitdk.LinkUp.connection_service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lalitdk.LinkUp.connection_service.Entity.Person;
import com.Lalitdk.LinkUp.connection_service.Service.ConnectionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class ConnectionController {

    private final ConnectionService connectionService;

    @GetMapping("/{userId}/first-degree")
    public ResponseEntity<List<Person>> getFirstConnection(@PathVariable Long userId) {
        return ResponseEntity.ok(connectionService.getFirstDegreeConnections(userId));
    }
}
