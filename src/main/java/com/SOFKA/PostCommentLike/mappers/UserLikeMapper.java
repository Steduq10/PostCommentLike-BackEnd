package com.SOFKA.PostCommentLike.mappers;

import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.dto.UserLikeDTO;
import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.entity.UserLike;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserLikeMapper {

    public UserLikeDTO convertUserLikeToDto(UserLike userLike){
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setUserName(userLike.getUserName());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setComments(userLikeDTO.getComments()); //REVIEW
        userLikeDTO.setPosts(userLikeDTO.getPosts()); // REVIEW
        return userLikeDTO;
    }

    public UserLike userLikeDtoMapper(UserLikeDTO userLikeDTO){
        UserLike userLike = new UserLike();
        userLike.setId(userLikeDTO.getId());
        userLike.setUserName(userLikeDTO.getUserName());
        userLike.setDni(userLike.getDni());
        //userLike.setPosts(userLikeDTO.getPosts().stream().map().collect(Collectors.toList()));
        //TERMINAR

        return userLike;
    }
}
