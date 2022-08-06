package com.SOFKA.PostCommentLike.repository;

import com.SOFKA.PostCommentLike.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeRepository extends JpaRepository<UserLike, Integer> {
}
