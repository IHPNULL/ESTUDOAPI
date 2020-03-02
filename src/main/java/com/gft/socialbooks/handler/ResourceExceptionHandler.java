package com.gft.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.socialbooks.domain.Detalheserro;
import com.gft.socialbooks.services.exceptions.Livronaoencontradoexception;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(Livronaoencontradoexception.class)
	public ResponseEntity<Detalheserro> handlelivronaoencontradoException(LayerInstantiationException e,
			HttpServletRequest request) {

		Detalheserro erro = new Detalheserro();
		
		erro.setStatus(404l);
		erro.setTitulo("o livro nao pode ser encontrado");
		erro.setMenssagem("http://errps.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
