package com.geekster.UserApplications.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "Id")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userId;
        private String name;
        @Column(nullable = false, unique = true)
        private String email;
        @Column(nullable = false)
        private String password;
        @Column(nullable = false)
        private String confirmPassword;

        public User(String name ,String mail , String password,String confirmPassword ){
            this.name = name;
            this.mail = mail;
            this.password = password;
            this.confirmPassword = confirmPassword;
        }
}

