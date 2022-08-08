package com.SOFKA.PostCommentLike.service;


import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.entity.Post;

public interface PostService {


    PostDTO createPost (PostDTO postDTO);
    PostDTO editPost (PostDTO postDTO);
    //void deletePost (Integer id);
    void deletePost (Post post);
}
