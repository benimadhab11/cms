package com.bmk.cms.service;

import com.bmk.cms.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<PostDto> getAllPosts();
    public PostDto createPost(PostDto postDto);
    public PostDto deletePost(Integer id);
    public PostDto updatePost(Integer id, PostDto postDto);
}
