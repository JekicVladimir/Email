package com.Email.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String path;

}
