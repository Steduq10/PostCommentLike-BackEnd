package com.SOFKA.PostCommentLike.mappers;

import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PostMapper {
    @Autowired
    UserLikeMapper userLikeMapper;

    @Autowired
    CommentMapper commentMapper;

    private PostDTO convertPostToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        //postDTO.setLikes(post.getLikes());
        postDTO.setNumberOfLikes(post.getNumberOfLikes());
       // postDTO.setUserLikes(post.getUserLikes());
        postDTO.setUserLikes(post.getUserLikes().stream().map(userLikeMapper::convertUserLikeToDto).collect(Collectors.toSet()));
        //postDTO.setComments(post.getComments());
        postDTO.setComments(post.getComments().stream().map(commentMapper::convertCommentToDto).collect(Collectors.toSet()));
        return postDTO;
    }

    public  Post dtoMapper(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getId());
        //TERMINAR

        return post;
    }
}
