package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.dto.UserLikeDTO;
import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.entity.UserLike;
import com.SOFKA.PostCommentLike.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getAllPost(){
        return postRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    private PostDTO convertEntityToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setLikes(post.getLikes());
        postDTO.setNumberOfLikes(post.getNumberOfLikes());
        postDTO.setUserLikes(post.getUserLikes());
        postDTO.setComments(post.getComments());
        return postDTO;
    }


    @Override
    public Post createPost(Post post) {
        Objects.requireNonNull(post);
        return postRepository.save(post);
    }

    @Override
    public Post editPost(Post post) {
        Objects.requireNonNull(post);
        Objects.requireNonNull(post.getId());

        postRepository.save(post);
        return post;
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
