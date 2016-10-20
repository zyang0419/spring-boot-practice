package com.baichou.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by root on 16-10-19.
 */

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@WebMvcTest(Application.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mvc;



//    @MockBean
//    private UserVehicleService userVehicleService;

    @Test
    public void getVehicleShouldReturnMakeAndModel() {
//        given(this.userVehicleService.getVehicleDetails("sboot"))
//                .willReturn(new VehicleDetails("Honda", "Civic"));

//        this.mvc.perform(get("/hello")
//                .accept(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello my spring boot application"));
    }


}
