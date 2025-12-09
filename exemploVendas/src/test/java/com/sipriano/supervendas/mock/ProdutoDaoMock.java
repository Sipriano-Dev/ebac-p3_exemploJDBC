package test.java.com.sipriano.supervendas.mock;

import main.java.com.sipriano.supervendas.dao.IProdutoDAO;
import main.java.com.sipriano.supervendas.domain.Produto;
import main.java.com.sipriano.supervendas.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ProdutoDaoMock implements IProdutoDAO {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(String valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return null;
    }

}
