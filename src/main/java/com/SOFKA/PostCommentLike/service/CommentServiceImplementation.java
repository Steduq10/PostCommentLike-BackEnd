package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        Objects.requireNonNull(comment);
        return commentRepository.save(comment);
    }

    @Override
    public Comment editComment(Comment comment) {
        Objects.requireNonNull(comment);
        Objects.requireNonNull(comment.getId());

        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
