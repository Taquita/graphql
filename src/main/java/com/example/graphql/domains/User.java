package com.example.graphql.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull(message = "Attribute 'name' can not be null")
    private String name;

    @NotNull(message = "Attribute 'email' can not be null")
    @Email(message = "Attribute 'email', is not an email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<Address> addresses;

}
