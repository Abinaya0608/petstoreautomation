package api.utilities;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataproviders {
  
  @DataProvider(name ="data")
  public String[][] getalldata() throws Exception 
  {
	  String path = "C:\\Users\\Admin\\eclipse-workspace\\petstoreautomation\\testdata\\Userdata.xlsx";
	  excelutilies xl=new excelutilies(path);
	  
	  int rowcount=xl.getRowCount("Test Sheet");
	  int columncount=xl.getCellCount("Test Sheet", 1);
	    	  
	  String [][] data= new String[rowcount][columncount];
	  
	  for (int i=1;i<=rowcount;i++)
	  {
		  for (int j=0;j<columncount;j++)
		  {
			  data[i-1][j]= xl.getCellData("Test Sheet", i, j);  
		  }

	  }  
	  return data;    
  }
  
  @DataProvider(name="usernames")
  public String[] getUserNames() throws Exception
  {
	  String path = "C:\\Users\\Admin\\eclipse-workspace\\petstoreautomation\\testdata\\Userdata.xlsx";
	  excelutilies xl=new excelutilies(path);
	  
	  int rowcount=xl.getRowCount("Test Sheet");
	  String [] data= new String[rowcount];
	  for(int i=1;i<=rowcount;i++)
	  {
		  data[i-1]=xl.getCellData("Test Sheet",i,1);
	  }
	  return data;
  }
  
}


