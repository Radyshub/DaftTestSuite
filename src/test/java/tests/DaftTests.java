package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DaftHome;
import pages.DaftSearch;

import java.util.Map;

public class DaftTests extends TestBase {

    DaftHome home;
    DaftSearch search;

    @Test(dataProvider = "getData")
    public void performDaftTest(int itr, Map<String,String> data){
        try{
            home = new DaftHome(getDriver());
            home.searchCity(data.get("searchinput"));
            search = new DaftSearch(getDriver());

            int propertyCount = search.getSearchPropertyResults();
            Assert.assertEquals(propertyCount >0, true, "Zero Search Result not expected");

            search.setFilterKeyword(data.get("keyword"));
            int filterCount = search.getFilterResultCount();
            Assert.assertEquals( filterCount >0, true, "Zero Filtered Result not expected");

            Assert.assertEquals(search.performSearchByFilterAndViewPropertyDesc().contains(data.get("keyword")),true,
                    data.get("keyword").toUpperCase() + " not found in property description");;

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
