package main.services.generics;

import main.domain.Persistente;
import main.exception.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente> {
    Boolean salvar(T entity) throws TipoChaveNaoEncontradaException;

    T consultar(Long valor);

    void excluir(Long valor);

    void alterar(T entity) throws TipoChaveNaoEncontradaException;
}
