package com.frasato.rpgannotation.repositories;

import com.frasato.rpgannotation.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, String> {

    @Query(value = "SELECT * FROM posts WHERE creator_user_id%:id%", nativeQuery = true)
    List<PostModel> findPostsByUser(@Param("id") String id);

}
