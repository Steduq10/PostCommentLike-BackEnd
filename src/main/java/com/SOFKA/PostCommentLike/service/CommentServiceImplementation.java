package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //Mapper
    private CommentDTO convertCommentToDto(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setLikes(comment.getLikes());
        commentDTO.setNumberOfLikes(comment.getNumberOfLikes());
        commentDTO.setUserLikes(comment.getUserLikes());
        return commentDTO;
    }

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
