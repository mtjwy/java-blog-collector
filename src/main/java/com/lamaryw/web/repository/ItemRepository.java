package com.lamaryw.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lamaryw.web.entity.Item;



public interface ItemRepository extends JpaRepository<Item, Integer>{

}
