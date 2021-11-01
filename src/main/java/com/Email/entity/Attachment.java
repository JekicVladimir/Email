package com.Email.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "attachment")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String path;

    @Column
    private String mimeType;

    @Column
    private String name;

}