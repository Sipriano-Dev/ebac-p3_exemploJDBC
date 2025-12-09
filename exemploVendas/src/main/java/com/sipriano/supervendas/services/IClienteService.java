package main.java.com.sipriano.supervendas.services;

import main.java.com.sipriano.supervendas.domain.Cliente;
import main.java.com.sipriano.supervendas.exceptions.DAOException;
import main.java.com.sipriano.supervendas.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}