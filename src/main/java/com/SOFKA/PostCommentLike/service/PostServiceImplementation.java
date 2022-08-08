package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.dto.UserLikeDTO;
import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.UserLike;
import com.SOFKA.PostCommentLike.mappers.PostMapper;
import com.SOFKA.PostCommentLike.repository.CommentRepository;
import com.SOFKA.PostCommentLike.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserLikeService userLikeService;

    @Autowired
    private CommentService commentService;

    public List<PostDTO> getAllPost(){
        return postRepository.findAll()
                .stream()
                .map(postMapper::convertPostToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createPost(PostDTO postDTO){
        System.out.println(postDTO);
        Post post = postMapper.dtoMapper(postDTO);
                return postMapper.convertPostToDto(postRepository.save(post));
    }

  /*  @Override
    public void createPost(PostDTO postDTO){
        postRepository.save(postMapper.dtoMapper(postDTO));

    }*/

    @Override
    public PostDTO editPost(PostDTO postDTO){
        var targetPost = postRepository.findById(postDTO.getId());
        if(targetPost.isPresent()){
            var postEdited = postRepository.save(postMapper.dtoMapper(postDTO));
            var postEditedDTO = postMapper.convertPostToDto(postEdited);
            return postEditedDTO;
        }
        throw new IllegalStateException("We couldn't find the post");
    }

    /*@Override
    public void editPost(PostDTO postDTO){
        Post targetPost = postRepository.getReferenceById(postDTO.getId());

        targetPost.setContent(postDTO.getContent());
        targetPost.setTitle(postDTO.getTitle());
    }*/
    //@Override
  //  public void deletePost(Integer id){
       /* Post targetPost = postRepository.getReferenceById(id);
        List<UserLike> postLikes = targetPost.getUserLikes();
        List<Comment> postComments = targetPost.getComments();
        postLikes.forEach(userLike -> userLikeService.deleteLike(userLike.getId()));
        postComments.forEach(comment -> commentService.deleteComment(comment.getId()));*/
      //  postRepository.deleteById(id);
  //  }

    @Override
    public void deletePost(Post post){
       Post postToBeDeleted = postRepository.findById(post.getId()).get();
       if (postToBeDeleted.getComments().size()>=0){
           postToBeDeleted.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
       }
       postRepository.deleteById(post.getId());
    }
}
