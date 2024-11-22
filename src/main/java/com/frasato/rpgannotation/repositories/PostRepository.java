package com.frasato.rpgannotation.repositories;

import com.frasato.rpgannotation.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, String> {}
