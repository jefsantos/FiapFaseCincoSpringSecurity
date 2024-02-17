package com.fiap.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fiap.model.Aparelhos;

@Service
public interface AparelhosService {
	
	Aparelhos criarAparelhos (Aparelhos aparelhos);
	Optional<Aparelhos> obterAparelhoPorId(UUID id);
	Aparelhos AtualizarAparelhos(Aparelhos aparelhos);
	void detelarAparelho(UUID id);
	List<Aparelhos> BuscarTodosAparelhosCadastrados();
	
	
	

}
