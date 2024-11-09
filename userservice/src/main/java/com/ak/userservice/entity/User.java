package com.ak.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_data")
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
