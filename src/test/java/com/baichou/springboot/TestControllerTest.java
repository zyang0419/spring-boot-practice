package com.baichou.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
  
@RunWith(SpringJUnit4ClassRunner.class)  
//@SpringApplicationConfiguration(classes = App.class)  //deprecated
//@ContextConfiguration(classes=MyApp.class, loader=SpringApplicationContextLoader.class)
//SpringApplicationBuilder
@WebAppConfiguration  
public class TestControllerTest {  
  
    MockMvc mvc;  
  
    @Autowired  
    WebApplicationContext webApplicationConnect;  
  
//    @Autowired
//    TestServices testServices;
  
    String expectedJson;  
  
    @Before  
    public void setUp() throws JsonProcessingException {  
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
  
    }

    @Test
    public void testShow() throws Exception {
       /* String expectedResult = "Hello World!";
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertFalse("错误，正确的返回值为200", status != 200);
        Assert.assertTrue("数据一致", expectedResult.equals(content));
        Assert.assertFalse("数据不一致", !expectedResult.equals(content));*/
    }


//    @Test
//    public void testShow() throws Exception {
//        String expectedResult = "hello world!";
//        String uri = "/show";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
//                .andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        String content = mvcResult.getResponse().getContentAsString();
//
//        Assert.assertTrue("错误，正确的返回值为200", status == 200);
//        Assert.assertFalse("错误，正确的返回值为200", status != 200);
//        Assert.assertTrue("数据一致", expectedResult.equals(content));
//        Assert.assertFalse("数据不一致", !expectedResult.equals(content));
//    }
//
//    protected String Obj2Json(Object obj) throws JsonProcessingException {
//        ObjectMapper mapper=new ObjectMapper();
//        return mapper.writeValueAsString(obj);
//    }
//
//    @Test
//    public void testShowDaoInt() throws Exception {
//        List<TestPOJO> testPOJOList = testServices.showDao(10);
//        expectedJson = Obj2Json(testPOJOList);
//
//        String uri="/showDao?age=10";
//        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
//        int status=mvcResult.getResponse().getStatus();
//        String content=mvcResult.getResponse().getContentAsString();
//
//        Assert.assertTrue("错误，正确的返回值为200", status == 200);
//        Assert.assertFalse("错误，正确的返回值为200", status != 200);
//        Assert.assertTrue("数据一致", expectedJson.equals(content));
//        Assert.assertFalse("数据不一致", !expectedJson.equals(content));
//    }
//
//    @Test
//    public void testShowDaoString() throws Exception {
//        List<HotelDto> hotelDtoList=testServices.findByCountry("US");
//        expectedJson = Obj2Json(hotelDtoList);
//
//        String uri="/country/US";
//        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
//        int status=mvcResult.getResponse().getStatus();
//        String content=mvcResult.getResponse().getContentAsString();
//
//        Assert.assertTrue("错误，正确的返回值为200", status == 200);
//        Assert.assertFalse("错误，正确的返回值为200", status != 200);
//        Assert.assertTrue("数据一致", expectedJson.equals(content));
//        Assert.assertFalse("数据不一致", !expectedJson.equals(content));
//    }
//
}  