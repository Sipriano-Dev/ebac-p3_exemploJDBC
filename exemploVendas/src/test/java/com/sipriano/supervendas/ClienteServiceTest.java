package test.java.com.sipriano.supervendas;

import main.java.com.sipriano.supervendas.dao.IClienteDAO;
import main.java.com.sipriano.supervendas.domain.Cliente;
import main.java.com.sipriano.supervendas.exceptions.DAOException;
import main.java.com.sipriano.supervendas.exceptions.TipoChaveNaoEncontradaException;
import main.java.com.sipriano.supervendas.services.ClienteService;
import main.java.com.sipriano.supervendas.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.com.sipriano.supervendas.mock.ClienteDaoMock;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campinas");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(88);
        cliente.setTel(1999999999L);

    }

    @Test
    public void pesquisarCliente() throws DAOException {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws DAOException {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        cliente.setNome("Anderson Sipriano");
        clienteService.alterar(cliente);

        Assert.assertEquals("Anderson Sipriano", cliente.getNome());
    }
}

