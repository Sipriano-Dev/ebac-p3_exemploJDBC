package test.java.com.sipriano.supervendas.mock;

import main.java.com.sipriano.supervendas.dao.IClienteDAO;
import main.java.com.sipriano.supervendas.domain.Cliente;
import main.java.com.sipriano.supervendas.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ClienteDaoMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }


}

