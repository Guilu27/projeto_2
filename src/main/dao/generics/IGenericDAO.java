package main.dao.generics;

import main.domain.Persistente;
import main.exception.TipoChaveNaoEncontradaException;


public interface IGenericDAO<T extends Persistente> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(Long valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(Long valor);

}