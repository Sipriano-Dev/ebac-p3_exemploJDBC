package main.java.com.sipriano.supervendas.services;

import main.java.com.sipriano.supervendas.dao.IProdutoDAO;
import main.java.com.sipriano.supervendas.domain.Produto;
import main.java.com.sipriano.supervendas.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}