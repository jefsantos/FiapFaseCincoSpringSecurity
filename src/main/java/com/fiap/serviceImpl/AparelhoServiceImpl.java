package com.fiap.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.model.Aparelhos;
import com.fiap.repository.AparelhosRepository;
import com.fiap.services.AparelhosService;

@Service
public class AparelhoServiceImpl implements AparelhosService{

	@Autowired
	AparelhosRepository repo;
	
	@Override
	public Aparelhos criarAparelhos(Aparelhos aparelhos) {
		return repo.save(aparelhos);
	}

	@Override
	public Optional<Aparelhos> obterAparelhoPorId(UUID id) {
		return repo.findById(id);
	}

	@Override
	public Aparelhos AtualizarAparelhos(Aparelhos aparelhos) {
		return repo.save(aparelhos);
	}

	@Override
	public void detelarAparelho(UUID id) {
		repo.deleteById( id);
	}

	@Override
	public List<Aparelhos> BuscarTodosAparelhosCadastrados() {
		return repo.findAll();
	}

}
