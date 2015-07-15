package br.com.alura.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.alura.loja.modelo.Projeto;

public class HashMapProjetoDao implements Projetos {

	private static Map<Long, Projeto> banco = new HashMap<>();
	private static AtomicLong contador = new AtomicLong(3);
	
	static {
		banco.put(1L, new Projeto(1, "Casa do Codigo", 2014));
		banco.put(2L, new Projeto(2, "Alura", 2013));
		banco.put(3L, new Projeto(2, "Caelum", 2002));
	}
	
	@Override
	public void adiciona(Projeto projeto) {
		banco.put(contador.getAndAdd(1), projeto);
	}
	
	@Override
	public Projeto busca(Long id) {
		return banco.get(id);
	}
	
	@Override
	public void remove(Long id) {
		banco.get(id);
	}
	
}
