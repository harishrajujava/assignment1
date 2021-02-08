package com.myshop.att.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.att.entities.HardSKU;

public interface CatalogRepository extends JpaRepository<HardSKU, String> {

}
