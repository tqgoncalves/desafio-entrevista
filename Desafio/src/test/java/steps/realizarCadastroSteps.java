package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class realizarCadastroSteps {
	
	private WebDriver driver;
	
	@Dado("que estou acessando a aplicação")
	public void que_estou_acessando_a_aplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tqg88\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://prova.stefanini-jgr.com.br/teste/qa/");
	    
	}

	@Quando("informo o nome {string}")
	public void informo_o_nome(String arg1) throws Throwable {
		driver.findElement(By.id("name")).sendKeys(arg1);
	    
	}

	@Quando("o e-mail {string}")
	public void o_e_mail(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	    
	}

	@Quando("a senha {string}")
	public void a_senha(String arg1) throws Throwable {
	    driver.findElement(By.id("password")).sendKeys(arg1);
	}

	@Quando("seleciono Cadastrar")
	public void seleciono_cadastrar() throws Throwable {
		driver.findElement(By.id("register")).click();;
	    
	}

	
	@Então("o usuário é inserido com sucesso {string}")
	public void o_usuário_é_inserido_com_sucesso(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/h2[2]")).getText();
	    Assert.assertEquals(arg1, texto);
	}
	
	@Então("o usuário recebe o aviso: O Campo Nome é obrigatório {string}")
	public void o_usuário_recebe_o_aviso_o_campo_nome_é_obrigatório(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[1]/p")).getText();
		Assert.assertEquals(arg1, texto);
	}

	@Então("o usuário recebe o aviso: O Campo E-mail é obrigatório {string}")
	public void o_usuário_recebe_o_aviso_o_campo_e_mail_é_obrigatório(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/p")).getText();
		Assert.assertEquals(arg1, texto);
	}
	
	@Então("o usuário recebe o aviso: O Campo Senha é obrigatório {string}")
	public void o_usuário_recebe_o_aviso_o_campo_senha_é_obrigatório(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[3]/p")).getText();
		Assert.assertEquals(arg1, texto);
		
		    
	}
	
	@Então("o usuário recebe o aviso: Insira um e-mail válido {string}")
	public void o_usuário_recebe_o_aviso_insira_um_e_mail_válido(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/p")).getText();
		Assert.assertEquals(arg1, texto);
	   
	}


	
	@Então("o usuário recebe o aviso: A senha deve conter ao menos oito caracteres. {string}")
	public void o_usuário_recebe_o_aviso_a_senha_deve_conter_ao_menos_oito_caracteres(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[3]/p")).getText();
		Assert.assertEquals(arg1, texto); 
	}
	
		
	
	@After (order = 10)
	public void ScreenShot(Scenario cenario) throws IOException {
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		
		File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/evidencias/"+cenario+".jpg");
		FileUtils.copyFile(SrcFile, destFile);

	}
	
	@After(order = 0)
	public void fecharBrowser() {
		driver.quit();
		System.out.println("terminando");
	}
	
}

