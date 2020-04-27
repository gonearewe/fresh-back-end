package com.mactavish.fresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mactavish.fresh.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}

