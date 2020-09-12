package com.bmk.cms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post implements Serializable {

    private static final long serialVersionUID = -2318546838178804959L;

    @Id
    @GeneratedValue
    private UUID postId;

    private String title;

    @Lob
    @Column(columnDefinition="TEXT")
    private String content;

    private String author;
    private String status;
    private Date date;


}
