package com.fiap.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.model.Aparelhos;
import com.fiap.services.AparelhosService;

@RestController
@RequestMapping("/api")
public class AparelhosController {

	@Autowired
	AparelhosService service;

	@GetMapping("/todosAparelhos")
	public ResponseEntity<?> listarAparelhos() {
		List<Aparelhos> lista = service.BuscarTodosAparelhosCadastrados();
		return ResponseEntity.ok(lista);

	}
	
	
	@GetMapping("/aparelhoPorId/{id}")
	public ResponseEntity<?> listarAparelhosPorId(@PathVariable UUID id) {
		Optional <Aparelhos> aparelhoEncontrado = service.obterAparelhoPorId(id);
		return ResponseEntity.ok(aparelhoEncontrado);

	}

	@PostMapping("/CadastrarNovoAparelho")
	public ResponseEntity<?> cadastrarAparelhos(@RequestBody Aparelhos aparelhos) {
		Aparelhos novoAparelho = service.criarAparelhos(aparelhos);

		return ResponseEntity.ok(novoAparelho);

	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletarAparelho(@PathVariable UUID id, Aparelhos aparelho) {
		Optional<Aparelhos> existe = service.obterAparelhoPorId(id);

		if (existe.isPresent()) {

			service.detelarAparelho(id);
			return ResponseEntity.ok("APARELHO DELETADO COM SUCESSO");
		}

		else {

			return ResponseEntity.badRequest().body("APARELHO NÃO LOCALIZADO");

		}
	}

}