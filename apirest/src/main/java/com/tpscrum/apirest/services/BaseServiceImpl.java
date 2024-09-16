package com.tpscrum.apirest.services;

import com.tpscrum.apirest.entities.Base;
import com.tpscrum.apirest.interfaces.BaseService;
import com.tpscrum.apirest.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<E> findAll() throws Exception {
        try {
            return baseRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            return baseRepository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E findById(ID id) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);
            return optional.isPresent() ? optional.get() : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (entityOptional.isPresent()) {
                Integer personId = entityOptional.get().getId();
                Boolean active = entityOptional.get().getActivo();
                entityOptional = Optional.of(entity);
                entityOptional.get().setId(personId);
                entityOptional.get().setActivo(active);
                return baseRepository.save(entityOptional.get());
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (entityOptional.isPresent()) {
                entityOptional.get().setActivo(false);
                baseRepository.save(entityOptional.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean existId(ID id) throws Exception {
        try {
            return baseRepository.existsById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
