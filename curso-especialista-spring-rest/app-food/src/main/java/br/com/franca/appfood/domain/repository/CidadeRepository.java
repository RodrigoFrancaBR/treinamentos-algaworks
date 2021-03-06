package br.com.franca.appfood.domain.repository;

import br.com.franca.appfood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);
	
}
