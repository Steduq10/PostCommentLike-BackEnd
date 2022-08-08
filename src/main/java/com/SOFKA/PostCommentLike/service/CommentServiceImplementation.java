package com.SOFKA.PostCommentLike.service;

import com.SOFKA.PostCommentLike.dto.CommentDTO;
import com.SOFKA.PostCommentLike.dto.PostDTO;
import com.SOFKA.PostCommentLike.entity.Comment;
import com.SOFKA.PostCommentLike.entity.Post;
import com.SOFKA.PostCommentLike.entity.UserLike;
import com.SOFKA.PostCommentLike.mappers.CommentMapper;
import com.SOFKA.PostCommentLike.repository.CommentRepository;
import com.SOFKA.PostCommentLike.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Objects;
@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserLikeService userLikeService;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO){
        return commentMapper
                .convertCommentToDto(commentRepository.save(commentMapper.commentDtoToEntity(commentDTO)));

    }


    /*
    @Override
    public void createComment(CommentDTO commentDTO){
        commentRepository.save(commentMapper.commentDtoToEntity(commentDTO)); //REVIEW
    }*/

   /* @Override
    public void editComment(CommentDTO commentDTO){
        Comment targetComment = commentRepository.getReferenceById(commentDTO.getId());

        targetComment.setContent(commentDTO.getContent());
    }*/

    @Override
    public CommentDTO editComment(CommentDTO commentDTO){
        var targetComment = commentRepository.findById(commentDTO.getId());
        if(targetComment.isPresent()){
            var commentEdited = commentRepository.save(commentMapper.commentDtoToEntity(commentDTO));
            var commentEditedDTO = commentMapper.convertCommentToDto(commentEdited);
            return commentEditedDTO;
        }
        throw new IllegalStateException("We couldn't find the comment");
    }
    //@Override
   // public void deleteComment(Integer id){
     //  /* Comment targetComment = commentRepository.getReferenceById(id);

      //  List<UserLike> commentLikes = targetComment.getUserLikes();
      //  commentLikes.forEach(userLike -> userLikeService.deleteLike(userLike.getId()));*/
      //  commentRepository.deleteById(id);
  // }

    @Override
    public void deleteComment(Comment comment){
        commentRepository.deleteById(comment.getId());
    }



}
