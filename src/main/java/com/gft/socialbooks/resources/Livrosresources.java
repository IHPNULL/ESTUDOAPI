package com.gft.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.socialbooks.domain.Comentario;
import com.gft.socialbooks.domain.Livro;
import com.gft.socialbooks.services.Livrosservice;

@RestController
@RequestMapping("/livros")
public class Livrosresources {

	@Autowired
	private Livrosservice livros;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(livros.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livro = livros.salvar(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		livros.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livros.atualizar(livro);
		return ResponseEntity.noContent().build();

	}

	// Buscar um objeto pelo ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Livro livro = livros.buscar(id);

		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livro);
	}

	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarComentario(@PathVariable(value = "id") final Long livroId,
			@RequestBody Comentario comentario) {

		// comentario.setUsuario(getAuthenticatedUser());
		livros.salvarcomentario(livroId, comentario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable(value = "id") final Long livroId) {

		List<Comentario> listaComentarios = Livrosservice.listarComentarios(livroId);
		return ResponseEntity.status(HttpStatus.OK).body(listaComentarios);
	}
}