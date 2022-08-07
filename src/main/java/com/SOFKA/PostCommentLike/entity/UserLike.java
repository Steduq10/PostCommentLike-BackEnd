package com.SOFKA.PostCommentLike.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_like")
@NoArgsConstructor
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_like", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "dni", length = 45)
    private String dni;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "comment_has_user_like",
            joinColumns = @JoinColumn(name = "user_like_iduser_like"),
            inverseJoinColumns = @JoinColumn(name = "comment_id_comments"))
    //private Set<Comment> comments = new LinkedHashSet<>();
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "post_has_user_like",
            joinColumns = @JoinColumn(name = "user_like_iduser_like"),
            inverseJoinColumns = @JoinColumn(name = "post_id_post"))
   // private Set<Post> posts = new LinkedHashSet<>();
    private List<Post> posts = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {return posts;}
    //public List<Post> getPosts() {
    //    return posts;
   // }
    public void setPosts(List<Post> posts) {this.posts = posts;}
    //public void setPosts(List<Post> posts) {this.posts = posts;}


}