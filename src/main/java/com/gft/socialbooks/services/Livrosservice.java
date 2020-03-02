package com.gft.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.socialbooks.domain.Livro;
import com.gft.socialbooks.repository.LivrosRep;
import com.gft.socialbooks.services.exceptions.Livronaoencontradoexception;

@Service
public class Livrosservice {

	@Autowired
	private LivrosRep livros;

	public List<Livro> listar() {
		return livros.findAll();
	}

	public Livro buscar(Long id) {
		Livro livro = livros.findById(id).get();

		if (livro == null) {
			throw new Livronaoencontradoexception("Livro nao encontrado");
		}

		return livro;
	}

	public Livro salvar(Livro livr) {
		livr.setId(null);
		return livros.save(livr);
	}

	public void deletar(Long id) {

		try {
			livros.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new Livronaoencontradoexception("Livro deletado");
		}
	}
	 
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livros.save(livro);
	}
	
	public void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
}
