package dao;

import main.dao.IProdutoDAO;
import main.domain.Produto;
import main.exception.TipoChaveNaoEncontradaException;

public class ProdutoDAOMock implements IProdutoDAO {
    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(Long valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }
}
