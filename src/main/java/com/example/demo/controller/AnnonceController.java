package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Annonce;
import com.example.demo.service.AnnonceService;

@Controller
public class AnnonceController {
	

	@Autowired
	AnnonceService annonceservice;
	
	@RequestMapping(value = "/annonce",  method = RequestMethod.GET)
	public ModelAndView formulaireAnnonce() {
		ModelAndView view = new ModelAndView("index", "annonce", new Annonce());
		
		
		
		return view;
		
	}

	
	@RequestMapping(value = "/addannonce", method = RequestMethod.POST)
    public  ModelAndView submit(HttpServletRequest request, Annonce annonce) {
		String title = request.getParameter("title");
		if (request.getParameter("title") == null) {
			title = "";
		}
		String description = request.getParameter("description");
		if (request.getParameter("description") == null) {
			description = "";
		}
		String error  = request.getParameter("error");

			
		

		if (title.isEmpty() || description.isEmpty()){
			
			if (title.isEmpty() && description.isEmpty()) {
				error = "VEUILLEZ REMPLIR LE TITRE ET LA DESCRIPTION";
			}
			else if (title.isEmpty()) {
				error = "VEUILLEZ REMPLIR LE TITRE";
			}
			else if (description.isEmpty()) {
				error = "VEUILLEZ REMPLIR LA DESCRIPTION";
			}
						
			ModelAndView view = new ModelAndView("index", "annonce", new Annonce());
			
			view.addObject("error", error);
			view.addObject("title", title);
			view.addObject("description", description);
			
			return view;

		}
		
		else {
			
			ModelAndView view = new ModelAndView("addannonce", "annonce", new Annonce());
			annonceservice.createAnnonce(annonce);
			
			return view;

		}
		}
	
	@RequestMapping(value = "/annoncelist", method = RequestMethod.GET)
	public String findAll(Model m, @RequestParam("page") int page) {
		Pageable allpage = PageRequest.of(page, 4);
		Page<Annonce> annonces = annonceservice.findAll(allpage);
		m.addAttribute("annonces", annonces.getContent());
		m.addAttribute("nextpage", page+1);
		m.addAttribute("previouspage", page-1);
		
		return "annoncelist";
	}
	
	

}
