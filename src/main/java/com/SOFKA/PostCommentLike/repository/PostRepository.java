package com.SOFKA.PostCommentLike.repository;

import com.SOFKA.PostCommentLike.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer >{

}
