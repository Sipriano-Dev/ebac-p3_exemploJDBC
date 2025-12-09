package test.java.com.sipriano.supervendas;

import main.java.com.sipriano.supervendas.dao.IProdutoDAO;
import main.java.com.sipriano.supervendas.domain.Produto;
import main.java.com.sipriano.supervendas.exceptions.DAOException;
import main.java.com.sipriano.supervendas.exceptions.TipoChaveNaoEncontradaException;
import main.java.com.sipriano.supervendas.services.IProdutoService;
import main.java.com.sipriano.supervendas.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.com.sipriano.supervendas.mock.ProdutoDaoMock;

import java.math.BigDecimal;

public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Mouse de pc");
        produto.setNome("Mouse");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() throws DAOException {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() throws DAOException {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        produto.setNome("Pendrive");
        produtoService.alterar(produto);

        Assert.assertEquals("Pendrive", produto.getNome());
    }
}
