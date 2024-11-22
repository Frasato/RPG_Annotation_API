package com.frasato.rpgannotation.repositories;

import com.frasato.rpgannotation.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {}
