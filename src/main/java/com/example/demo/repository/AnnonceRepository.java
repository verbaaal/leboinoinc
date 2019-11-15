package com.example.demo.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Annonce;

public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Long> {

	Page<Annonce> findAll(Pageable pageable);
	
	
	
}