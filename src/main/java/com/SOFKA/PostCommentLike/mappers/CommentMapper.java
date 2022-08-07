package com.SOFKA.PostCommentLike.mappers;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommentMapper {
    @Autowired
    UserLikeMapper userLikeMapper;

    //Mapper
    public CommentDTO convertCommentToDto(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setPostIdPost(comment.getPostIdPost());
        commentDTO.setLikes(comment.getLikes());
        commentDTO.setNumberOfLikes(comment.getNumberOfLikes());
        //commentDTO.setUserLikes(comment.getUserLikes());
        commentDTO.setUserLikes(comment.getUserLikes().stream().map(userLikeMapper::convertUserLikeToDto).collect(Collectors.toSet()));
        return commentDTO;
    }
    public Comment dtoToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setPostIdPost(commentDTO.getPostIdPost());
       // comment.setUserLikes(commentDTO.getUserLikes());
        //TERMINAR

        return comment;
    }
}
