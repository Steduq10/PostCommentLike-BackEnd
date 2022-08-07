package com.SOFKA.PostCommentLike.dto;

import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.entity.UserLike;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class CommentDTO {
    private Integer id;

    @Size(min= 10 ,max= 255, message = "The element doesn't have the right amount of characters")
    private String content;

    @Min(value= 0 ,message = "The element doesn't have the right amount of characters")
    private String numberOfLikes;

    //private String likes;
    private Post postIdPost;
   // private Set<UserLikeDTO> userLikes = new LinkedHashSet<>();
    private List<UserLikeDTO> userLikes = new ArrayList<>();
}
