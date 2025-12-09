package main.java.com.sipriano.supervendas.services;

import main.java.com.sipriano.supervendas.dao.IClienteDAO;
import main.java.com.sipriano.supervendas.domain.Cliente;
import main.java.com.sipriano.supervendas.exceptions.DAOException;
import main.java.com.sipriano.supervendas.exceptions.MaisDeUmRegistroException;
import main.java.com.sipriano.supervendas.exceptions.TableException;
import main.java.com.sipriano.supervendas.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    //private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        //this.clienteDAO = clienteDAO;
    }

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}

