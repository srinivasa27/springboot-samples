/*
package com.example.tinyurl.repository;

import com.example.tinyurl.entity.TinyUrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class TinyUrlRepositoryImpl implements TinyUrlRepository {

    @Autowired
    EntityManager entityManager;


    @Override
    public <S extends TinyUrlEntity> S save(S s) {
        entityManager.persist(s);
        entityManager.flush();
        return s;
    }


    @Override
    public List<TinyUrlEntity> findAll() {
        entityManager.createQuery("Select t from " + TinyUrlEntity.getSimpleName() + " t").getResultList();

    }

    @Override
    public List<TinyUrlEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TinyUrlEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TinyUrlEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TinyUrlEntity tinyUrl) {

    }

    @Override
    public void deleteAll(Iterable<? extends TinyUrlEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TinyUrlEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TinyUrlEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends TinyUrlEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TinyUrlEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TinyUrlEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends TinyUrlEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TinyUrlEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TinyUrlEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TinyUrlEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TinyUrlEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TinyUrlEntity> boolean exists(Example<S> example) {
        return false;
    }
}
*/
