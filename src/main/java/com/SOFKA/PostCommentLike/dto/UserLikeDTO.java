package com.SOFKA.PostCommentLike.dto;

import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.Post;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserLikeDTO {
    private Integer id;

    @Size(min= 10 ,max= 50, message = "The element doesn't have the right amount of characters")
    private String userName;
    @Size(min= 8 ,max= 20, message = "The element doesn't have the right amount of characters")
    private String dni;
    private Set<CommentDTO> comments = new LinkedHashSet<>();
    //private List<Comment> comments = new ArrayList<>();
    private Set<PostDTO> posts = new LinkedHashSet<>();
    //private List<Post> posts = new ArrayList<>();
}
