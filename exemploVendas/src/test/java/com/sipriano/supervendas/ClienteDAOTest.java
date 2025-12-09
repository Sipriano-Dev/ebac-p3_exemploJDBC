package test.java.com.sipriano.supervendas;

import main.java.com.sipriano.supervendas.dao.ClienteDAO;
import main.java.com.sipriano.supervendas.dao.IClienteDAO;
import main.java.com.sipriano.supervendas.domain.Cliente;
import main.java.com.sipriano.supervendas.exceptions.DAOException;
import main.java.com.sipriano.supervendas.exceptions.MaisDeUmRegistroException;
import main.java.com.sipriano.supervendas.exceptions.TableException;
import main.java.com.sipriano.supervendas.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campinas");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(88);
        cliente.setTel(1999999999L);
        cliente.setNacionalidade("Brasileira");
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campinas");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(88);
        cliente.setTel(1999999999L);
        cliente.setNacionalidade("Brasileira");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }


    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campinas");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(88);
        cliente.setTel(1999999999L);
        cliente.setNacionalidade("Brasileira");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campinas");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(88);
        cliente.setTel(1999999999L);
        cliente.setNacionalidade("Brasileira");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Anderson Sipriano");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Anderson Sipriano", clienteAlterado.getNome());

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(56565656565L);
        cliente.setNome("Anderson");
        cliente.setCidade("Campinas");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNacionalidade("Brasileira");
        cliente.setNumero(88);
        cliente.setTel(1999999999L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(12345678912L);
        cliente1.setNome("Anderson 2");
        cliente1.setCidade("Campinas");
        cliente1.setEnd("Endereço 2");
        cliente1.setEstado("SP");
        cliente1.setNacionalidade("Brasileira");
        cliente1.setNumero(89);
        cliente1.setTel(1999999999L);
        Boolean retorno1 = clienteDao.cadastrar(cliente1);
        assertTrue(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }
}
