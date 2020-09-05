package com.bmk.cms.controller;


import com.bmk.cms.dto.PostDto;
import com.bmk.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllPerson() {

        return new ResponseEntity<Object>(postService.getAllPosts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public ResponseEntity<String> persistPerson(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
