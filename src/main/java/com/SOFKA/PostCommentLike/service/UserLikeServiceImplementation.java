package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.dto.UserLikeDTO;
import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.UserLike;
import com.SOFKA.PostCommentLike.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserLikeServiceImplementation implements UserLikeService{


    @Autowired
    private UserLikeRepository userLikeRepository;

    @Override
    public UserLike giveLike(UserLike userLike) {
        Objects.requireNonNull(userLike);
        return userLikeRepository.save(userLike);
    }

    @Override
    public void deleteLike(Integer id) {
        userLikeRepository.deleteById(id);
    }
}
