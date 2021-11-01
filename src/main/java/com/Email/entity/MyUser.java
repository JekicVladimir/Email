package com.Email.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter @NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
//    @JsonIgnore
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Account_id")
    private List<Account> accounts = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Tag_id")
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Contact_id")
    private List<Contact> contacts = new ArrayList<>();

}
