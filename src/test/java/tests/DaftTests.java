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
            Assert.assertTrue(propertyCount >0,"Zero Search Result not expected");
            search.setFilterKeyword(data.get("keyword"));
            int filterCount = search.getFilterResultCount();
            Assert.assertTrue(filterCount >0,"Zero Filtered Result not expected" );
            Assert.assertTrue(search.performSearchByFilterAndViewPropertyDesc().toLowerCase().contains(data.get("keyword")),data.get("keyword").toUpperCase() + " not found in property description" );
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
