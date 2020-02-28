package com.gft.socialbooks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		}
			
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public void deletar(@PathVariable("id") Long id)
		{
			livros.deleteById(id);
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public void editar(@RequestBody Livro livro, @PathVariable("id") Long id)
		{
			livro.setId(id);
			livros.save(livro);
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
			Livro livro = livros.findById(id).get();
			
			if(livro == null)
			{
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(livro);
		}		
}
