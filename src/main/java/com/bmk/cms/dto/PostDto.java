package com.bmk.cms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class PostDto {
    private UUID id;
    private String title;
    private String content;
    private String author;
    private String status;
    private Date date;

}
