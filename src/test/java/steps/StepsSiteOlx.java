package steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class StepsSiteOlx {

	private WebDriver driver;
	private String url = "https://www.olx.com.br/";
	// inserir o email para executar o teste
	private String email = "teste15885@gmail.com";
	// inserir a senha para executar o teste
	private String senha = "15teste885";

	@Before
	public void iniciando() {
		System.setProperty("webdriver.chome.driver", "target\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void finalizando() {
//		driver.quit();
	}

	// validando a tag @login
	// validacao OK
	@Dado("que acesso a tela de login")
	public void queAcessoATelaDeLogin() {
		driver.findElement(By.linkText("Entrar")).click();
	}

	// validação OK
	@Quando("preencher os campos email e senha")
	public void preencherOsCamposEmailESenha() {
		driver.findElement(By.xpath("//*[@id='__next']//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='__next']//input[@type='password']")).sendKeys(senha);
	}

	// validação OK
	@Quando("clicar no botao entrar")
	public void clicarNoBotaoEntrar() {
		driver.findElement(By.xpath("//*[@id='__next']//button[.='Entrar']")).click();
	}

	// validação OK
	@Entao("o login sera efetuado")
	public void oLoginSeraEfetuado() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		String usuario = driver.findElement(By.xpath("//*[@class='sc-kyCyAI brUCvn']//span[.='teste']")).getText();
		assertEquals("teste", usuario);
	}

	// validando a tag @logout
	// validacao OK
	@Dado("que acesso o site olx")
	public void queAcessoOSiteOlx() {
//		queAcessoATelaDeLogin();
//		preencherOsCamposEmailESenha();
//		clicarNoBotaoEntrar();
	}

	// validação OK
	@Quando("clicar em sair")
	public void clicarEmSair() {
		driver.findElement(By.xpath("//*[@class='sc-kyCyAI brUCvn']//span[.='teste']")).click();
		driver.findElement(By.xpath("//a[.='Sair']")).click();
	}

	// validação OK
	@Entao("usuario efetuara o logout")
	public void usuarioEfetuaraOLogout() {
		String logout = driver.findElement(By.xpath("//*[@id='___gatsby']//span[.='Entrar']")).getText();
		assertEquals("Entrar", logout);
	}

	// validando a tag @logout
	// validacao OK
	@Quando("buscar o produto")
	public void buscarOProduto() {
//		driver.findElement(By.xpath("//*[@id='main-page-content']//a")).click();
//		driver.findElement(By.xpath("//*[@id='root']//a")).click();
		driver.findElement(By.xpath("//*[@class='iza-top']//input[@type='text']")).sendKeys("Tracker 20/21");
		driver.findElement(By.xpath("//*[@class='iza-top']//button")).click();
//		driver.findElement(By.xpath("//*[@id='react-autowhatever-1']/../input")).sendKeys("Tracker 20/21");
//		driver.findElement(By.xpath("//*[@id='react-autowhatever-1']/../../..//button")).click();
	}

	// validação OK
	@Quando("selecionar o estado")
	public void selecionarOEstado() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id='content']//a[.='Brasil']")).click();
		driver.findElement(By.linkText("Paraná")).click();
	}

	@Entao("exibira o produto selecionado")
	public void exibiraOProdutoSelecionado() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		String estado = driver.findElement(By.xpath("//*[@id='content']//h1[.='\"Tracker 20/21\" no Paraná']"))
				.getText();
		assertEquals("\"Tracker 20/21\" no Paraná", estado);

		String produto = driver.findElement(By.xpath("//*[@id='content']//h2[.='Tracker 20/21']")).getText();
		assertEquals("Tracker 20/21", produto);
	}

}
