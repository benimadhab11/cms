package com.bmk.cms.service;

import com.bmk.cms.dto.PostDto;
import com.bmk.cms.model.Post;
import com.bmk.cms.repo.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDto> getAllPosts() {
        return convertToListDto(postRepository.findAll());
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        postRepository.save(convertToEntity(postDto));
        return null;
    }

    private List<PostDto> convertToListDto(List<Post> allPostEntities) {
        List<PostDto> allPostDtos = new ArrayList<>();
        allPostEntities.forEach(post -> {
            allPostDtos.add(modelMapper.map(post, PostDto.class));
        });

        return allPostDtos;
    }

    private Post convertToEntity(PostDto postDto) {
        Post post =   modelMapper.map(postDto, Post.class);
        post.setDate(new Date());
        return post;
    }




}
