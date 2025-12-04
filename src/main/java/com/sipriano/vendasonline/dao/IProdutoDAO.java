package main.java.com.sipriano.vendasonline.dao;

import main.java.com.sipriano.vendasonline.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto buscar(String codigo) throws Exception;

    public List<Produto> buscarTodos() throws Exception;

    public Integer excluir(Produto produto) throws Exception;

}
