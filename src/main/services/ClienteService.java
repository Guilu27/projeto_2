package main.services;

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.services.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService {

    public ClienteService(IClienteDAO dao) {
        super(dao);
    }
}
