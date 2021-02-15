package steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class StepsSiteOlx {

	private WebDriver driver;
	private String url = "https://www.olx.com.br/";
	
	//Modificar o email e a senha na feature
	//inserir o nome do usuario que será exibido no login da OLX
	private String usuario = "";

	@After
	public void finalizando() {
		driver.quit();
	}

	@Dado("que acesso o site OLX")
	public void queAcessoOSiteOLX() {
		System.setProperty("webdriver.chome.driver", "target\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();

	}

	@Quando("preencher o campo nome com {string}")
	public void preencherOCampoNomeCom(String email) {
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.cssSelector("input[autocomplete=email]")).sendKeys(email);

		//validando o email digitado
		assertEquals(email, driver.findElement(By.cssSelector("input[autocomplete=email]")).getAttribute("value"));
	}

	@Quando("preencher o campo senha com {string}")
	public void preencherOCampoSenhaCom(String senha) {
		driver.findElement(By.cssSelector("input[autocomplete=none]")).sendKeys(senha);

		//validando a senha digitada
		assertEquals(senha, driver.findElement(By.cssSelector("input[autocomplete=none]")).getAttribute("value"));
	}

	@Quando("clicar no botão Entrar")
	public void clicarNoBotãoEntrar() {
		driver.findElement(By.xpath(".//button[.='Entrar']")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@Entao("efetuará o login do usuario")
	public void efetuaráOLoginDoUsuario() {
//		driver.navigate().refresh();
		assertEquals("Meus anúncios", driver.findElement(By.xpath(".//h1[.='Meus anúncios']")).getText());

	}

	@Quando("preencho o campo busca com {string}")
	public void preenchoOCampoBuscaCom(String produto) {
		//clicando no link Buscar
		driver.findElement(By.linkText("Buscar")).click();
		
		//preenchendo o campo Buscar
		driver.findElement(By.xpath("//*[@id='search-by-word-container']//input")).click();
		driver.findElement(By.xpath("//*[@id='search-by-word-container']//input")).sendKeys(produto);
		driver.findElement(By.xpath("//*[@id='search-by-word-container']//button")).click();

	}

	@Quando("seleciono o estado {string}")
	public void selecionoOEstado(String estado) {
		driver.findElement(By.linkText(estado)).click();
	}

	@Entao("exibira o produto selecionado")
	public void exibiraOProdutoSelecionado() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		//validando o estado 
		String anuncio = driver.findElement(By.xpath("//*[@id='content']//h1")).getText();
		assertEquals("\"Tracker 20/21\" no Paraná", anuncio);

		// validando o produto
		String produto = driver.findElement(By.xpath("//*[@id='content']//h2[.='Tracker 20/21']")).getText();
		assertEquals("Tracker 20/21", produto);

	}

	@Quando("clicar no nome do usuario")
	public void clicarNoNomeDoUsuario() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//header//span[.='" + usuario + "']")).click();

	}

	@Quando("clicar em sair")
	public void clicarEmSair() {
		driver.findElement(By.xpath("//a[.='Sair']")).click();

	}

	@Entao("efetuara o logout")
	public void efetuaraOLogout() {
		String logout = driver.findElement(By.xpath("//*[@id='___gatsby']//span[.='Entrar']")).getText();
		assertEquals("Entrar", logout);

	}

}
