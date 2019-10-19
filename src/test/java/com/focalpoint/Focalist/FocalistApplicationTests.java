package com.focalpoint.Focalist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FocalistApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetHomepageIsOkAndContainsFocaList() throws Exception{
		this.mockMvc.perform(get("/")).andDo(print())

				.andExpect(view().name("home"))
				.andExpect(status().is(200))
				.andExpect(content().string(containsString("<title>Focalist</title>")));
	}
}
