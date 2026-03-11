package com.bezkoder.spring.jpa.h2.specifications;

import com.bezkoder.spring.jpa.h2.model.Comment;
import org.springframework.data.jpa.domain.Specification;
public class CommentSpecifications {

    public static Specification<Comment> authorNameLike(String authorName) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("authorName")), "%" + authorName.toLowerCase() + "%");
    }

    public static Specification<Comment> hasTutorialId(Long tutorialId) {
        return (root, query, cb) ->
                cb.equal(root.get("tutorial").get("id"), tutorialId);
    }

    public static Specification<Comment> contentLike(String content) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("content")), "%" + content.toLowerCase() + "%");
    }
}
