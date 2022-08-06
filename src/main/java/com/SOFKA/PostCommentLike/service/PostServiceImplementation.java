package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

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
