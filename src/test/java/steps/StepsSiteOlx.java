package steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

	
	//validacao OK
	@Dado("que acesso o site OLX")
	public void queAcessoOSiteOLX() {
		System.setProperty("webdriver.chome.driver", "target\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	
	//validacao OK
	@Quando("logar no sistema")
	public void logarNoSistema() throws InterruptedException {
		driver.findElement(By.linkText("Entrar")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id='__next']//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='__next']//input[@type='password']")).sendKeys(senha);
		driver.findElement(By.xpath("//*[@id='__next']//button[.='Entrar']")).click();
		
		//atualizando pagina do navegador
		Thread.sleep(5000);
		
	}

	
	//validacao OK
	@Quando("procurar um produto")
	public void procurarUmProduto() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		//buscando o produto
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id='root']//a[.='Buscar']")).click();
		driver.findElement(By.xpath("//*[@id='search-by-word-container']//input")).click();
		driver.findElement(By.xpath("//*[@id='search-by-word-container']//input")).sendKeys("Tracker 20/21");
		driver.findElement(By.xpath("//*[@id='search-by-word-container']//button")).click();
		
		//selecionando o estado do parana
		driver.findElement(By.linkText("Paraná")).click();
		
	}

	
	//validação OK
	@Entao("exibira o produto selecionado")
	public void exibiraOProdutoSelecionado() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//validando o estado 
		String estado = driver.findElement(By.xpath("//*[@id='content']//h1[.='\"Tracker 20/21\" no Paraná']"))
				.getText();
		assertEquals("\"Tracker 20/21\" no Paraná", estado);

		//validando o produto
		String produto = driver.findElement(By.xpath("//*[@id='content']//h2[.='Tracker 20/21']")).getText();
		assertEquals("Tracker 20/21", produto);
		
		
		//efetuando o logout
		driver.findElement(By.xpath("//*[@id='header-container']//span[.='teste']")).click();
		driver.findElement(By.xpath("//a[.='Sair']")).click();
//		driver.findElement(By.xpath("//*[@class='sc-kyCyAI brUCvn']//span[.='teste']")).click();
//		driver.findElement(By.xpath("//a[.='Sair']")).click();
		
		//validando o logout
		String logout = driver.findElement(By.xpath("//*[@id='___gatsby']//span[.='Entrar']")).getText();
		assertEquals("Entrar", logout);
		
		driver.quit();
	}
	
}
