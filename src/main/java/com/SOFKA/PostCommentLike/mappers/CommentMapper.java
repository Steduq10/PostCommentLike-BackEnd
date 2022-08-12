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
        //commentDTO.setPostIdPost(postMapper.convertPostToDto(comment.getPostIdPost()));
        commentDTO.setNumberOfLikes(comment.getNumberOfLikes());
        commentDTO.setUserLikes(comment.getUserLikes().stream().map(userLikeMapper::convertUserLikeToDto).collect(Collectors.toList()));
        return commentDTO;
    }
    public Comment commentDtoToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setPostIdPost(commentDTO.getPostIdPost());
       // comment.setPostIdPost(postMapper.convertPostToDto(commentDTO.getPostIdPost()));
        comment.setNumberOfLikes(commentDTO.getNumberOfLikes());
        comment.setUserLikes(commentDTO.getUserLikes().stream().map(userLikeMapper::userLikeDtoMapper).collect(Collectors.toList()));
        return comment;
    }
}
