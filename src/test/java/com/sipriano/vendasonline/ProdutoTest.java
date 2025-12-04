package test.java.com.sipriano.vendasonline;

import main.java.com.sipriano.vendasonline.dao.IProdutoDAO;
import main.java.com.sipriano.vendasonline.dao.ProdutoDAO;
import main.java.com.sipriano.vendasonline.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;


    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("3");
        produto.setNome("Mouse Gamer");
        produto.setPreco(99.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("3");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("3");
        produto.setNome("Mouse Gamer");
        produto.setPreco(99.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("3");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("3");
        produto.setNome("Mouse Gamer");
        produto.setPreco(99.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("3");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("3");
        produto.setNome("Mouse Gamer");
        produto.setPreco(99.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto2 = new Produto();
        produto2.setCodigo("6");
        produto2.setNome("Pendrive");
        produto2.setPreco(60.00);
        Integer countCad2 = produtoDAO.cadastrar(produto2);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto pro : list) {
            produtoDAO.excluir(pro);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("3");
        produto.setNome("Mouse Gamer");
        produto.setPreco(99.00);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("3");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());

        produtoBD.setCodigo("13");
        produtoBD.setNome("Outro Mouse Gamer");
        produtoBD.setPreco(120.00);
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDAO.buscar("3");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("13");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        assertEquals(produtoBD.getPreco(), produtoBD2.getPreco());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto pro : list) {
            produtoDAO.excluir(pro);
        }
    }
    
}
