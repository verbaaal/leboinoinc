package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Annonce;
import com.example.demo.repository.AnnonceRepository;

@Service
public class AnnonceService {
	
	@Autowired
	AnnonceRepository annoncerepo;
	
	public Annonce createAnnonce(Annonce annonce) {
		return annoncerepo.save(annonce);
	}
	
	public Page<Annonce> findAll(Pageable pageable) {
		return annoncerepo.findAll(pageable);
	}
	
	

}
