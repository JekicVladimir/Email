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
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

}