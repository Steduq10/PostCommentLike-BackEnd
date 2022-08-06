package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.entity.UserLike;


public interface UserLikeService {
    UserLike giveLike (UserLike userLike);
    void  deleteLike (Integer id);
}
