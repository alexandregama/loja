package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Projeto;

public interface Projetos {

	void adiciona(Projeto projeto);

	Projeto busca(Long id);

	void remove(Long id);

}
