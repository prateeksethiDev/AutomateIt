package auutomateIt.fixtures.dataProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import automateIt.utils.ExcelReader;
import auutomateIt.fixtures.beans.AdminUserBean;

public class UserDataProvider {

	
	ExcelReader obj = new ExcelReader();

    @DataProvider(name = "createUserDataProvider")
    public Iterator<AdminUserBean> createUserDataProvider(){
    	Map<String,List<Map<String,String>>> notationMappedRows= obj.
        		readDataFromExcel(System.getProperty("user.dir")+"/resources/testData/orangeHRMData.xlsx","AdminUserBean");
    	List<Map<String, String>> listOfData=notationMappedRows.get("createUserDataProvider");
    	Iterator<Map<String, String>> itr=listOfData.iterator();
        ArrayList<AdminUserBean> listOfBean = new ArrayList<AdminUserBean>();
       while(itr.hasNext()){
           Map<String, String> map=  itr.next();
           String role=map.get("userRole");
           String employeeName=map.get("employeeName");
           String userName=map.get("userName");
           String status=map.get("status");
           String password=map.get("password");
           String confirmPassword=map.get("confirmPassword");
           listOfBean.add(new AdminUserBean(role,employeeName,userName,status,password,confirmPassword));
       }
       return listOfBean.iterator();
    }
    
    @DataProvider(name = "searchUserDataProvider")
    public Iterator<AdminUserBean> searchUserDataProvider(){
    	Map<String,List<Map<String,String>>> notationMappedRows = obj.
        		readDataFromExcel(System.getProperty("user.dir")+"/resources/testData/orangeHRMData.xlsx","AdminUserBean");
    	List<Map<String, String>> listOfData=notationMappedRows.get("searchUserDataProvider");	
        Iterator<Map<String, String>> itr=listOfData.iterator();
        ArrayList<AdminUserBean> listOfBean = new ArrayList<AdminUserBean>();
       while(itr.hasNext()){
           Map<String, String> map=  itr.next();
           String role=map.get("userRole");
           String employeeName=map.get("employeeName");
           String userName=map.get("userName");
           String status=map.get("status");
           String password=map.get("password");
           String confirmPassword=map.get("confirmPassword");
           listOfBean.add(new AdminUserBean(role,employeeName,userName,status,password,confirmPassword));
       }
       return listOfBean.iterator();
    }
}
