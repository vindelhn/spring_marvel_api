package com.siman.marvel_api.repository;

import com.siman.marvel_api.model.UserSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSearchRepository extends JpaRepository<UserSearch, Long> {

        List<UserSearch> findAllByUsername(String username);

}
