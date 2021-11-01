package com.Email.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Attachment_id")
    private List<Attachment> attachments = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "message_has_tag",
            joinColumns = { @JoinColumn(name = "Message_id") },
            inverseJoinColumns = { @JoinColumn(name = "Tag_id") })
            private List<Tag> tags = new ArrayList<>();
}
