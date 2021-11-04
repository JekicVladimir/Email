package com.Email.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "attachment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="path")
    private String path;

    @Column(name="mime_type")
    private String mimeType;

    @Column(name="name")
    private String name;

}