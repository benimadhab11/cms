package com.bmk.cms.controller;


import com.bmk.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class ProducerController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllPosts() {
        return new ResponseEntity<Object>(postService.getAllPosts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/post/getOne/{postId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getPost(@PathVariable("postId") UUID postId) {
        return new ResponseEntity<Object>(postService.getPost(postId), HttpStatus.OK);
    }



}
