package com.Email.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String from;
    @Column
    private String to;
    @Column
    private String cc;
    @Column
    private String bcc;
    @Column
    private Date dateTime;
    @Column
    private String subject;
    @Column
    private String content;
    @Column
    private String unread;




}
