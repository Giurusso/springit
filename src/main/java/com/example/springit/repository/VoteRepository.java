package com.example.springit.repository;

import com.example.springit.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {

}
