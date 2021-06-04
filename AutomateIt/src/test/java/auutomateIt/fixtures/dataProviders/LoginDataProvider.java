package auutomateIt.fixtures.dataProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import automateIt.utils.ExcelReader;
import auutomateIt.fixtures.beans.LoginUserBean;

public class LoginDataProvider {
	
ExcelReader obj = new ExcelReader();

	@DataProvider(name = "validUserLoginDataProvider")
    public Iterator<LoginUserBean> validUserLoginDataProvider(){
    	Map<String,List<Map<String,String>>> notationMappedRows= obj.
        		readDataFromExcel(System.getProperty("user.dir")+"/resources/testData/orangeHRMData.xlsx","LoginUserBean");
    	List<Map<String, String>> listOfData=notationMappedRows.get("validUserLoginDataProvider");
    	Iterator<Map<String, String>> itr=listOfData.iterator();
        ArrayList<LoginUserBean> listOfBean = new ArrayList<LoginUserBean>();
       while(itr.hasNext()){
           Map<String, String> map=  itr.next();
           String username=map.get("username");
           String password=map.get("password");
           
           listOfBean.add(new LoginUserBean(username,password));
       }
       return listOfBean.iterator();
    }
}