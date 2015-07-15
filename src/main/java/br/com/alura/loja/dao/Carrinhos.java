package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Carrinho;

public interface Carrinhos {

	void adiciona(Carrinho carrinho);

	Carrinho busca(Long id);

	Carrinho remove(long id);

}
