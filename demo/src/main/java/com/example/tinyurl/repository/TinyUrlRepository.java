package com.example.tinyurl.repository;

import com.example.tinyurl.entity.TinyUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface  TinyUrlRepository extends JpaRepository<TinyUrlEntity, Long> {

}
