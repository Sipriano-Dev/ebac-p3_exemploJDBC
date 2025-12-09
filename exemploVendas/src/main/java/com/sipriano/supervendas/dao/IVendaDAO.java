package main.java.com.sipriano.supervendas.dao;

import main.java.com.sipriano.supervendas.dao.generic.IGenericDAO;
import main.java.com.sipriano.supervendas.domain.Venda;
import main.java.com.sipriano.supervendas.exceptions.DAOException;
import main.java.com.sipriano.supervendas.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}

