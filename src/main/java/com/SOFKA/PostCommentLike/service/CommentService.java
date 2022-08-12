package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.entity.Comment;

public interface CommentService {
    CommentDTO createComment (CommentDTO commentDTO);

    CommentDTO editComment (CommentDTO commentDTO);
    void deleteComment (Integer id);
    //void deleteComment (Comment comment);
}
