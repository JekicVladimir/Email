package com.Email.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String displayName;

    @Column
    private String email;

    @Column
    private String note;

}
