package com.SOFKA.PostCommentLike.controller;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.repository.CommentRepository;
import com.SOFKA.PostCommentLike.service.CommentServiceImplementation;
import com.SOFKA.PostCommentLike.service.PostServiceImplementation;
import com.SOFKA.PostCommentLike.service.UserLikeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class GeneralController {
    @Autowired
    private PostServiceImplementation postService;

    @Autowired
    private CommentServiceImplementation commentService;

    @Autowired
    private UserLikeServiceImplementation userLikeService;

    @GetMapping("get/all/post")
    public List<PostDTO> getAllPost(){
       return postService.getAllPost();
    }

    @PostMapping("save/post")
    public PostDTO createPost(PostDTO postDTO){
        return postService.createPost(postDTO);
    }

    @PostMapping("save/comment")
    public CommentDTO createComment(CommentDTO commentDTO){
        return commentService.createComment(commentDTO);
    }

    @PutMapping("edit/post")
    public PostDTO editPost(PostDTO postDTO){
        return postService.editPost(postDTO);
    }

    @PutMapping("edit/comment")
    public CommentDTO editComment(CommentDTO commentDTO){
        return commentService.editComment(commentDTO);
    }

    @DeleteMapping("delete/post")
    public void deletePost(Integer id){
        postService.deletePost(id);
    }

    @DeleteMapping("delete/comment")
    public void deleteComment(Integer id){
        commentService.deleteComment(id);
    }

}
