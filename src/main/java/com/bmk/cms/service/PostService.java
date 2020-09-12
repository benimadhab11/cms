package com.bmk.cms.service;

import com.bmk.cms.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PostService {

    public List<PostDto> getAllPosts();
    public PostDto getPost(UUID id);
    public PostDto createPost(PostDto postDto);
    public PostDto deletePost(UUID id);
    public PostDto updatePost(UUID id, PostDto postDto);
}
