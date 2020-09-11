package com.bmk.cms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
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
    @Type(type = "org.hibernate.type.TextType")
    private String content;
    private String author;
    private String status;
    private Date date;


}
