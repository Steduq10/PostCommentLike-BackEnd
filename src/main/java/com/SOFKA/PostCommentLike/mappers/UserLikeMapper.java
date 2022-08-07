package com.SOFKA.PostCommentLike.mappers;

import com.SOFKA.PostCommentLike.dto.UserLikeDTO;
import com.SOFKA.PostCommentLike.entity.UserLike;
import org.springframework.stereotype.Component;

@Component
public class UserLikeMapper {

    public UserLikeDTO convertUserLikeToDto(UserLike userLike){
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setUserName(userLike.getUserName());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setComments(userLikeDTO.getComments());
        userLikeDTO.setPosts(userLikeDTO.getPosts());
        return userLikeDTO;
    }
}
