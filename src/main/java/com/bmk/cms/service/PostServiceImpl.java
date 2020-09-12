package com.bmk.cms.service;

import com.bmk.cms.dto.PostDto;
import com.bmk.cms.model.Post;
import com.bmk.cms.repo.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public PostDto deletePost(UUID id) {
        postRepository.deleteById(id);
        return null;
    }

    @Override
    public PostDto updatePost(UUID id, PostDto postDto) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()){
            postRepository.save(updateToEntity(optionalPost.get(),postDto));
        }
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

    private Post updateToEntity(Post post, PostDto postDto) {
        post.setAuthor(postDto.getAuthor());
        post.setContent(postDto.getContent());
        post.setStatus(postDto.getStatus());
        post.setTitle(postDto.getTitle());
        post.setDate(new Date());
        return post;
    }




}
