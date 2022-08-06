package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.entity.UserLike;
import com.SOFKA.PostCommentLike.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeServiceImplementation implements UserLikeService{
    @Autowired
    private UserLikeRepository userLikeRepository;

    @Override
    public UserLike giveLike(UserLike userLike) {
        return null;
    }

    @Override
    public void deleteLike(Integer id) {
        userLikeRepository.deleteById(id);
    }
}
