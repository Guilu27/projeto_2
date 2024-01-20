package main.dao;

import main.dao.generics.GenericDAO;
import main.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {
    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {

    }
}
