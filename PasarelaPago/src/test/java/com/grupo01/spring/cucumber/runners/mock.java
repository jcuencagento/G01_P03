package com.grupo01.spring.cucumber.runners;

/*@WebMvcTest(HolaControllerPlus.class)
public class Spring11Test06_ApplicationMock {

    @Autowired    
 private MockMvc mockMvc;
 @MockBean    private HolaServicePlus serv;

    @Test    
 void contextLoads() throws Exception {

             //Fijate que en la linea 49 no es autowired sino que es un mock        //si anulo la linea siguiente realmente no inyecta una capa de servicios               
  when(serv.saludar()).thenReturn("noPluus");

        mockMvc.perform(get("/Plus")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Plus")));    
 }

}*/


