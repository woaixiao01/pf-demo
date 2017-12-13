package com.efun.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efun.micro.entity.Like;


public interface LikeRepository extends JpaRepository<Like, Long> {

}
