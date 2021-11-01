package com.Email.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String smtpAddress;
    @Column
    private int smtpPort;
    @Column
    private int inServerType;
    @Column
    private String inServerAddress;
    @Column
    private int inServerPort;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String displayname;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Message_id")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Folder_id")
    private List<Folder> folders = new ArrayList<>();

}
