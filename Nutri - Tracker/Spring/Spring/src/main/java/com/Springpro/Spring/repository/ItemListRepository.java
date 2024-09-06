package com.Springpro.Spring.repository;

import com.Springpro.Spring.Item_List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemListRepository extends JpaRepository<Item_List, Integer> {
    Optional<Item_List> findByCode(Long code);
}
