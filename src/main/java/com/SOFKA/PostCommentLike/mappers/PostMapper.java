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

    public PostDTO convertPostToDto(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setNumberOfLikes(post.getNumberOfLikes());
        postDTO.setUserLikes(post.getUserLikes().stream().map(userLikeMapper::convertUserLikeToDto).collect(Collectors.toList()));
        postDTO.setComments(post.getComments().stream().map(commentMapper::convertCommentToDto).collect(Collectors.toList()));
        return postDTO;
    }

    public  Post dtoMapper(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setNumberOfLikes(postDTO.getNumberOfLikes());
        post.setUserLikes(postDTO.getUserLikes().stream().map(userLikeMapper::userLikeDtoMapper).collect(Collectors.toList()));
        post.setComments(postDTO.getComments().stream().map(commentMapper::commentDtoToEntity).collect(Collectors.toList()));
        return post;
    }
}
