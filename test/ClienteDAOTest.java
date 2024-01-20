import dao.ClienteDAOMock;
import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO iClienteDAO;
    private Cliente cliente;

    public ClienteDAOTest() {
        iClienteDAO = new ClienteDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12345678901L);
        cliente.setNome("Maria Silva");
        cliente.setCidade("São Paulo");
        cliente.setEndereco("Rua das Flores");
        cliente.setEstado("SP");
        cliente.setNumero(456);
        cliente.setTelefone(987654321L);
        iClienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = iClienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = iClienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iClienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Maria da Silva");
        iClienteDAO.alterar(cliente);

        Assert.assertEquals("Maria da Silva", cliente.getNome());
    }
}
