package com.bmk.cms.controller;

import com.bmk.cms.dto.PostDto;
import com.bmk.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ConsumerController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post/createPost", method = RequestMethod.POST)
    public ResponseEntity<String> persistPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/post/updatePost/{postId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePost(@RequestBody PostDto postDto, @PathVariable("postId") int postId) {
        postService.updatePost(postId, postDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/post/deletePost/{postId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removePost(@PathVariable("postId") int postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
