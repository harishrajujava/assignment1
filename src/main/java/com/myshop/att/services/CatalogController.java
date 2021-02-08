package com.myshop.att.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.att.dao.CatalogDao;
import com.myshop.att.entities.ISKU;

@RestController
@RequestMapping("/api/v1")
public class CatalogController {

	@Autowired
	private CatalogDao catalogDao;
	
	@GetMapping(value = "catalog/sku/{skuId}")
    public ResponseEntity<ISKU> findOrderById(@PathVariable("skuId") String skuId) {
		return new ResponseEntity<>(catalogDao.findCatalog(skuId), HttpStatus.OK);
    }
}
