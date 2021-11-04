package com.Email.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="smtp_address")
    private String smtpAddress;

    @Column(name="smtp_port")
    private int smtpPort;

    @Column(name="in_server_type")
    private int inServerType;

    @Column(name="in_server_address")
    private String inServerAddress;

    @Column(name="in_server_port")
    private int inServerPort;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="display_name")
    private String displayname;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Message_id")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Message_id")
    private List<Folder> folders = new ArrayList<>();

}
