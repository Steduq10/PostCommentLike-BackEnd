package com.SOFKA.PostCommentLike.repository;

import com.SOFKA.PostCommentLike.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Integer>{
}
