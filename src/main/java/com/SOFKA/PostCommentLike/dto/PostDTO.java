package com.SOFKA.PostCommentLike.dto;


import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.UserLike;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class PostDTO {
    private Integer id;
    @Size(min= 5 ,max= 50, message = "The element doesn't have the right amount of characters")
    private String title;

    @Size(min= 10 ,max= 255, message = "The element doesn't have the right amount of characters")
    private String content;
    @Min(value= 0 ,message = "The element doesn't have the right amount of characters")
    private Integer numberOfLikes;
  //  private String likes;
   // private Set<CommentDTO> comments = new LinkedHashSet<>();
    private List<CommentDTO> comments = new ArrayList<>();
   // private Set<UserLikeDTO> userLikes = new LinkedHashSet<>();
    private List<UserLikeDTO> userLikes = new ArrayList<>();
}
