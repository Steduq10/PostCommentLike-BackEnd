package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.entity.Comment;

public interface CommentService {
    Comment createComment (Comment comment);
    Comment editComment (Comment comment);
    void deleteComment (Integer id);
}
