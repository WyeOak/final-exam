package com.example.exam.repository;

import com.example.exam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByPlaceId(Integer placeId);
}
