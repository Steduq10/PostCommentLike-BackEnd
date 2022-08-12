package com.SOFKA.PostCommentLike.controller;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.Post;
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

    @PostMapping("create/post")
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        return postService.createPost(postDTO);
    }

    @PostMapping("create/comment")
    public CommentDTO createComment(@RequestBody  CommentDTO commentDTO){
        return commentService.createComment(commentDTO);
    }

    @PutMapping("edit/post")
    public PostDTO editPost(@RequestBody PostDTO postDTO){
        return postService.editPost(postDTO);
    }

    @PutMapping("edit/comment")
    public CommentDTO editComment(@RequestBody CommentDTO commentDTO){
        return commentService.editComment(commentDTO);
    }

   /* @DeleteMapping("delete/post/{id}")
    public void deletePost(@PathVariable Integer id){
        postService.deletePost(id);
    }*/

    @DeleteMapping("delete/post")
    public void deletePost(@RequestBody Post post){
        postService.deletePost(post);
    }

    @DeleteMapping("delete/comment/{id}")
    public void deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
    }
   /* @DeleteMapping("delete/comment")
    public void deleteComment(@RequestBody Comment comment){
        commentService.deleteComment(comment);
    }*/

}
