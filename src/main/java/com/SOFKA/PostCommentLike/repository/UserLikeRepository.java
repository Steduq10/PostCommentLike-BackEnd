package com.SOFKA.PostCommentLike.repository;

import com.SOFKA.PostCommentLike.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Integer> {
}
