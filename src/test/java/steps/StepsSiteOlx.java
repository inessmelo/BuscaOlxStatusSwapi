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
	private String email = "teste15885@gmail.com";
	private String senha = "15teste885";
	private String usuario = "teste";

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
	// validação OK
	@Dado("que acesso a tela de login")
	public void queAcessoATelaDeLogin() {
		driver.findElement(By.xpath("//*[@class='sc-emmjRN koQeqJ']//span[.='Entrar']")).click();
	}

	// validação OK
	@Quando("preencher os campos email e senha")
	public void preencherOsCamposEmailESenha() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
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
		driver.findElement(By.xpath("//*[@id='__next']//a")).click();
		String nome = driver.findElement(By.xpath("//*[@class='sc-eerKOB juBRqq']//span[.='teste']")).getText();
		assertEquals("teste", nome);
	}

	// Acessa bloeuado por excessivas tentativas
	// validando a tag @busca
	// validação OK
	@Dado("que acesso o site olx")
	public void queAcessoOSiteOlx() {
		queAcessoATelaDeLogin();
		preencherOsCamposEmailESenha();
		clicarNoBotaoEntrar();

		// redirecionando para a tela principal
		driver.findElement(By.xpath("//*[@id='__next']//a")).click();
	}

	// validação OK
	@Quando("buscar o produto")
	public void buscarOProduto() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id='react-autowhatever-1']/../input")).sendKeys("Tracker 20/21");
		driver.findElement(By.xpath("//*[@id='react-autowhatever-1']/../../..//button")).click();
	}

	@Quando("selecionar o estado")
	public void selecionarOEstado() {
		// selecionando o estado do Paraná
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@class='h3us20-2 bdQAUC']//a[.='Brasil']")).click();
		driver.findElement(By.linkText("Paraná")).click();

		// validando o estado
		String estado = driver
				.findElement(By.xpath("//*[@id='column-main-content']//h1[.='\"Tracker 20/21\" no Paraná']")).getText();
		assertEquals("\"Tracker 20/21\" no Paraná", estado);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// não está funcionando
//		driver.findElement(By.xpath("//*[@id='ad-list']//h2[.='Tracker 20/21']")).click();
//		driver.findElement(By.xpath("//*[@id='ad-list']//img")).click();
//		driver.findElement(By.xpath("//h2[@title='Tracker 20/21']")).click();
//		driver.findElement(By.xpath("//div[@class='fnmrjs-6 iNpuEh']")).click();
		driver.findElement(By.xpath("//*[@id='ad-list']//a")).click();
	}

	// validação OK
	@Entao("exibira o produto")
	public void exibiraOProduto() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		String link = "https://pr.olx.com.br/regiao-de-londrina/autos-e-pecas/carros-vans-e-utilitarios/tracker-20-21-842850093";
		driver.get(link);

		String produto = driver.findElement(By.xpath("//*[@class='en9h1n-0 kKbJNQ']//h1[.='Tracker 20/21']")).getText();
		assertEquals("Tracker 20/21", produto);
	}

	// validando a tag @logout
	// validaçao
	@Quando("clicar em sair")
	public void clicarEmSair() {
		driver.findElement(By.xpath("//*[@class='sc-fhYwyz oljyb']//span[.='teste']")).click();
		driver.findElement(By.xpath("//*[@class='sc-fjdhpX fUKTLX sc-gHboQg exLNXi']//li/a[.='Sair']")).click();
	}

	@Entao("efetuara o lougout")
	public void efetuaraOLougout() {
		String logout = driver.findElement
				(By.xpath("//*[@id='__next']//span[.='teste, que bom te ver aqui de novo']")).getText();
		assertEquals("teste, que bom te ver aqui de novo", logout);
	}

}
