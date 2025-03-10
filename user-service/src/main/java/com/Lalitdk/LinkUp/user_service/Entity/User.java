package com.Lalitdk.LinkUp.user_service.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private  String Password;


}
