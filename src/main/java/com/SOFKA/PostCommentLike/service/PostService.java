package com.SOFKA.PostCommentLike.service;


import com.SOFKA.PostCommentLike.entity.Post;

public interface PostService {


    Post createPost (Post post);
    Post editPost (Post post);
    void deletePost (Integer id);
}
