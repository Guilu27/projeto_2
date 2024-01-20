import dao.ProdutoDAOMock;
import main.dao.IProdutoDAO;
import main.domain.Produto;
import main.exception.TipoChaveNaoEncontradaException;
import main.services.IProdutoService;
import main.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoServiceTest {
    private IProdutoService iProdutoService;
    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDAOMock();
        iProdutoService = new ProdutoService(dao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(3001L);
        produto.setNome("Bola Adidas Fevernova");
        produto.setPreco(199.99);
        iProdutoService.salvar(produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = iProdutoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        boolean retorno = iProdutoService.salvar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirProduto() {
        iProdutoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setNome("Bola Adidas Teamgeist");
        iProdutoService.alterar(produto);

        Assert.assertEquals("Bola Adidas Teamgeist", produto.getNome());
    }
}
