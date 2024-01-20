import dao.ProdutoDAOMock;
import main.dao.IProdutoDAO;
import main.domain.Produto;
import main.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {
    private IProdutoDAO iProdutoDAO;

    private Produto produto;

    public ProdutoDAOTest() {
        iProdutoDAO = new ProdutoDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(3001L);
        produto.setNome("Bola Adidas Fevernova");
        produto.setPreco(199.99);
        iProdutoDAO.cadastrar(produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = iProdutoDAO.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        boolean retorno = iProdutoDAO.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iProdutoDAO.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setNome("Bola Adidas Teamgeist");
        iProdutoDAO.alterar(produto);

        Assert.assertEquals("Bola Adidas Teamgeist", produto.getNome());
    }
}

