package com.myshop.att.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.att.entities.ISKU;
import com.myshop.att.repositories.CatalogRepository;

@Service
public class CatalogDao {

	@Autowired
	private CatalogRepository catalogRepository;

	public ISKU findCatalog(String skuId) {
		return catalogRepository.findById(skuId).orElse(null);
	}
}
