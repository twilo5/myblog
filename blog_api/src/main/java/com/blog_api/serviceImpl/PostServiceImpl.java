package com.blog_api.serviceImpl;

import com.blog_api.entity.Post;
import com.blog_api.payload.PostDto;
import com.blog_api.repository.PostRepository;
import com.blog_api.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTittle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post save = postRepository.save(post);
        PostDto dto = new PostDto();
        dto.setTittle(save.getTitle());
        dto.setDescription(save.getDescription());
        dto.setContent(save.getContent());
        return dto;
    }
}
