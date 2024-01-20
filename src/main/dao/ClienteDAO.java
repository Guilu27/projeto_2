package main.dao;

import main.dao.generics.GenericDAO;
import main.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {


    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
