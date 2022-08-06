package com.SOFKA.PostCommentLike.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comments", nullable = false)
    private Integer id;

    @Column(name = "content", nullable = false, length = 45)
    private String content;

    @Column(name = "number_of_likes", length = 45)
    private String numberOfLikes;

    @Column(name = "likes", length = 45)
    private String likes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id_post", nullable = false)
    private Post postIdPost;

    @ManyToMany
    @JoinTable(name = "comment_has_user_like",
            joinColumns = @JoinColumn(name = "comment_id_comments"),
            inverseJoinColumns = @JoinColumn(name = "user_like_iduser_like"))
    private Set<UserLike> userLikes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(String numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Post getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(Post postIdPost) {
        this.postIdPost = postIdPost;
    }

    public Set<UserLike> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<UserLike> userLikes) {
        this.userLikes = userLikes;
    }

}