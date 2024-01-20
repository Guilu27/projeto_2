import dao.ClienteDAOMock;
import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exception.TipoChaveNaoEncontradaException;
import main.services.ClienteService;
import main.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService iClienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        iClienteService = new ClienteService(dao);
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
        iClienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = iClienteService.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = iClienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iClienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Maria da Silva");
        iClienteService.alterar(cliente);

        Assert.assertEquals("Maria da Silva", cliente.getNome());
    }
}
