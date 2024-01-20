package main.services.generics;

import main.dao.generics.IGenericDAO;
import main.domain.Persistente;
import main.exception.TipoChaveNaoEncontradaException;

public abstract class GenericService<T extends Persistente> implements IGenericService<T> {

    IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }


    @Override
    public Boolean salvar(T entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public T consultar(Long valor) {
        return this.dao.consultar(valor);
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {

    }
}
