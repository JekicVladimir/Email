package com.Email.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="from")
    private String from;

    @Column(name="to")
    private String to;

    @Column(name="cc")
    private String cc;

    @Column(name="bcc")
    private String bcc;

    @Column(name="date_time")
    private Date dateTime;

    @Column(name="subject")
    private String subject;

    @Column(name="content")
    private String content;

    @Column(name="unread")
    private String unread;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Message_id")
    private List<Attachment> attachments = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "message_has_tag",
            joinColumns = { @JoinColumn(name = "Message_id") },
            inverseJoinColumns = { @JoinColumn(name = "Tag_id") })
            private List<Tag> tags = new ArrayList<>();
}
