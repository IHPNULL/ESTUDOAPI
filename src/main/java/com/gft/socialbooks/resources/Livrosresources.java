package com.gft.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.socialbooks.domain.Livro;
import com.gft.socialbooks.repository.LivrosRep;

@RestController
@RequestMapping("/livros")
public class Livrosresources {

		@Autowired
		private LivrosRep livros;
	
		@RequestMapping(method = RequestMethod.GET)
		public List<Livro> listar() {
			return livros.findAll();
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public void salvar(@RequestBody Livro livro)
		{
			livros.save(livro);
		}
}
