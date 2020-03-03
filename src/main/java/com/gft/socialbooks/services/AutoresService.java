package com.gft.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.socialbooks.domain.Autor;
import com.gft.socialbooks.services.exceptions.Autorexistenteexception;
import com.gft.socialbooks.services.exceptions.Autornaoencontradoexception;
import com.gft.socialbooks.repository.AutoresRep;

@Service
public class AutoresService {

	@Autowired
	private AutoresRep autoresRep;

	public List<Autor> listar() {
		return autoresRep.findAll();
	}

	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			if (autoresRep.findById(autor.getId()) != null) {
				throw new Autorexistenteexception("O autor já existe");
			}
		}
		return autoresRep.save(autor);
	}

	public Autor buscar(final Long id) {
		Autor autor = autoresRep.findById(id).get();

		if (autor == null) {
			throw new Autornaoencontradoexception("O autor não foi encontrado.");
		}

		return autor;

	}

	public void verificarExistencia(final Autor autor) {
		if (autor != null && autor.getId() != null) {
			buscar(autor.getId());
		}
	}

}
