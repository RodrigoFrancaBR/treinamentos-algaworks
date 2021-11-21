package br.com.franca.appfood.api.controller;

import br.com.franca.appfood.domain.dtos.CozinhasXmlWrapper;
import br.com.franca.appfood.domain.exception.EntidadeEmUsoException;
import br.com.franca.appfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.franca.appfood.domain.model.Cozinha;
import br.com.franca.appfood.domain.repository.CozinhaRepository;
import br.com.franca.appfood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listarJson() {
		System.out.println("produzindo MediaType.APPLICATION_JSON_VALUE");
		return cozinhaRepository.listar();
	}

//	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
//	public List<Cozinha> listarXML() {
//		System.out.println("produzindo MediaType.APPLICATION_XML_VALUE");
//		return cozinhaRepository.listar();
//	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarCozinhasXmlWrapper() {
		System.out.println("produzindo CozinhasXmlWrapper");
		List<Cozinha> cozinhas = cozinhaRepository.listar();
		CozinhasXmlWrapper cozinhasXmlWrapper = new CozinhasXmlWrapper(cozinhas);
		return cozinhasXmlWrapper;
	}

	@GetMapping("/id/{id}")
	public Cozinha buscarCozinhaPorID(@PathVariable("id") Long cozinhaId){
		System.out.println(cozinhaId);
		return cozinhaRepository.buscar(cozinhaId);
	}
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
											 @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);

		if (cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

			cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
		try {
			cadastroCozinha.excluir(cozinhaId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
