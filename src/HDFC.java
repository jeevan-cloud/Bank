import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HDFC {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\Goutham\\Workspace\\Eclipse\\Bank\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");

		driver.manage().window().maximize();
		Thread.sleep(1000);
		switchfame(driver,"login_page");

		driver.findElement(By.cssSelector("input[name=fldLoginUserId]")).sendKeys("75509134");
		driver.findElement(By.cssSelector("td:nth-child(2) > a > img")).click();
		driver.findElement(By.cssSelector("input[name=fldPassword]")).sendKeys("Sunny#2001");
		driver.findElement(By.cssSelector("tr:nth-child(7) > td > a > img")).click();
		
			

        	
		waittime( driver,"frame[name=left_menu]");		
        switchfame( driver,"left_menu");
		driver.findElement(By.cssSelector("#enquiryatag > i")).click();
		driver.findElement(By.cssSelector("#SBI_nohref > a > span")).click();
		//waittime( driver,"frame[name=main_part]");
		Thread.sleep(1000);
		switchfame(driver,"main_part");
		//waittime(driver,"select[name=selAccttype]");
		Thread.sleep(3000);
		select(driver,"select[name=selAccttype]","Saving And Current Accounts");
		select(driver,"select[name=selAcct]","50100210761074  -GAJUWAKA");
	    driver.findElement(By.cssSelector("tr:nth-child(3) > td > a")).click();
	    switchfame( driver,"left_menu");
		driver.findElement(By.cssSelector("#STH_nohref > a > span")).click();
		Thread.sleep(3000);
		switchfame(driver,"main_part");
		Thread.sleep(3000);
		select(driver,"select[name=selAcct]","50100210761074   - GAJUWAKA");
		driver.findElement(By.cssSelector("tr:nth-child(3) > td.DataLeftAligned > span")).click();
		driver.findElement(By.cssSelector("div:nth-child(1) > button > span.ui-button-icon-primary.ui-icon.ui-icon-calendar")).click();
		datepicker(driver,"11/11/2019","select.ui-datepicker-year","select.ui-datepicker-month");
		driver.findElement(By.cssSelector("div:nth-child(3) > button > span.ui-button-icon-primary.ui-icon.ui-icon-calendar")).click();
		datepicker(driver,"21/05/2020","select.ui-datepicker-year","select.ui-datepicker-month");
		select(driver,"select[name=fldFormatType]","PDF");
		//driver.findElement(By.cssSelector("tr:nth-child(5) > td > a > img")).click();

	    
	    
	}
	
	
	public static void switchfame(WebDriver driver,String cssname){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name="+cssname+"]")));
	}
	
	
	public static void waittime(WebDriver driver,String css) throws InterruptedException{
		for (int c=0;c<=7000;c++){
 			Thread.sleep(1);
     		try{
	     		if(driver.findElement(By.cssSelector(css)).isDisplayed()){
	     			break;
	     		}
     		}catch (Exception e) {
   		      System.out.println(e.getMessage());
   		    }
 		}
		
	}
	public static void select(WebDriver driver,String css,String item){
		 Select std=new Select(driver.findElement(By.cssSelector(css)));
		    std.selectByVisibleText(item);
	}
	
	
	public static void datepicker(WebDriver driver,String sd,String css_y,String css_m){
		
		
		 //String sd = "12/04/2019";
		  String [] a = sd.split("/");
		  String mon = null;

		  if(a[1].equals("01")){
		  mon = "Jan";
		  }else if(a[1].equals("02")){
		  mon = "Feb";
		  }else if(a[1].equals("03")){
		  mon = "Mar";
		  }else if(a[1].equals("04")){
		  mon = "Apr";
		  }else if(a[1].equals("05")){
		  mon = "May";
		  }else if(a[1].equals("06")){
		  mon = "Jun";
		  }else if(a[1].equals("07")){
		  mon = "Jul";
		  }else if(a[1].equals("08")){
		  mon = "Aug";
		  }else if(a[1].equals("09")){
		  mon = "Sep";
		  }else if(a[1].equals("10")){
		  mon = "Oct";
		  }else if(a[1].equals("11")){
		  mon = "Nov";
		  }else if(a[1].equals("12")){
		  mon = "Dec";
		  }


		  select(driver,css_y,a[2]);
		  select(driver,css_m,mon);
		  driver.findElement(By.xpath("//a[.='"+a[0]+"']")).click();
	// hdfc
	}
	
	
		
}

	


