package javaproject11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class aaa {
	@SuppressWarnings("deprecation")
	
	public static void main(String[] args) throws IOException {
		System.setProperty("WebDriver.gecko.driver","D:\\New folder\\geckodriver-v0.34.0-win32 (1)\\geckodriver.exe");
		WebDriver wd= new FirefoxDriver();
		 wd.get("https://accounts.google.com/v3/signin/identifier?hl=en-gb&ifkv=ASKXGp3k3iwzkQAtDJBi-bjKUHceqZKcnMuqft5bG7dgZR07nVT5DwLJMbhBo6UHWwlFOpiDBXwN&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-2130435347%3A1704260844249353&theme=glif");
		    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    
		    File excel=new File("C:\\Users\\user\\Downloads\\cynoteck\\datadriven.xlsx"); 
		    FileInputStream fis=new FileInputStream(excel); 
		       XSSFWorkbook book=new XSSFWorkbook(fis);
		       XSSFSheet sheet=book.getSheet("Sheet1"); 
		   
		       int rowcount=sheet.getLastRowNum(); 	 
		       
		       for(int i=0;i<=rowcount;i++) {
		           String username=sheet.getRow(i).getCell(0).getStringCellValue();
		           String password=sheet.getRow(i).getCell(1).getStringCellValue();
		           
		         
		          wd.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		          wd.findElement(By.cssSelector("input[type='email']")).clear();
		          wd.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		         
		          
		             
		          //wd1.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		   	    
		   	
		}
		 book.close();      
		
	}

}
