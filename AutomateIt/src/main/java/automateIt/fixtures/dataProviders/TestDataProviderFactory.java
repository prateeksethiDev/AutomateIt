package automateIt.fixtures.dataProviders;

import automateIt.fixtures.beans.AdminUserBean;
import automateIt.fixtures.utilities.*;
import org.testng.annotations.*;
import java.util.*;

public class TestDataProviderFactory {

    ExcelReader obj = new ExcelReader();

    @DataProvider(name = "getAdminUserDataProvider")
    public Iterator<AdminUserBean> getAdminUserDataProvider(){
        List<Map<String, String>> listOfData= obj.readDataFromExcel(System.getProperty("user.dir")+"resources/testData/orangeHRMData.xlsx","AdminUserBean");
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

