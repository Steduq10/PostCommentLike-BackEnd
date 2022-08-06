package com.SOFKA.PostCommentLike.mappers;

import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    private PostDTO convertPostToDto(Post post){
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
}
