package com.mercado.mercado.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.mercado.dto.param.MercadoParam;
import com.mercado.mercado.dto.request.MercadoRequest;
import com.mercado.mercado.repository.MercadoRepository;

@RestController
@RequestMapping("mercado")
public class MercadoController {

	MercadoRepository repository = new MercadoRepository();

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		List<MercadoRequest> list = repository.getListMercados();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{mercadoId}")
	public ResponseEntity<?> getMercadoById(@PathVariable("mercadoId") String id) {

		MercadoRequest mercado = repository.findById(id);
		if (mercado.getId() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mercado não encontrado");
		}
		return ResponseEntity.ok(mercado);
	}

	@GetMapping("/mercado")
	public ResponseEntity<?> getMercadoByName(@RequestParam(required = true) String nome) {
		MercadoRequest mercado = repository.findByName(nome);
		if (mercado.getId() == null) {
			return ResponseEntity.ok("Mercado não encontrado");
		}
		return ResponseEntity.ok(mercado);
	}

	@PostMapping("/")
	public ResponseEntity<?> postMercado(@Valid @RequestBody MercadoParam mercadoParam) {
		repository.addMercado(mercadoParam);
		return ResponseEntity.ok(mercadoParam);
	}

	@PutMapping("/{mercadoId}")
	public ResponseEntity<?> updateMercado(@PathVariable("mercadoId") String id,
			@RequestBody MercadoParam mercadoParam) {
		MercadoRequest mercado = repository.findById(id);
		if (mercado.getId() == null) {
			return ResponseEntity.ok("Mercado não encontrado");
		}
		repository.updateMercado(mercado, mercadoParam);
		return ResponseEntity.ok("Mercado atualizado com sucesso!");
	}

	@DeleteMapping("/{mercadoId}")
	public ResponseEntity<?> deleteMercado(@PathVariable("mercadoId") String id) {
		MercadoRequest mercado = repository.findById(id);
		if (mercado.getId() == null) {
			return ResponseEntity.ok("Mercado não encontrado");
		}
		repository.deleteMarcado(mercado);
		return ResponseEntity.ok("Mercado deletado com sucesso!");
	}

}
