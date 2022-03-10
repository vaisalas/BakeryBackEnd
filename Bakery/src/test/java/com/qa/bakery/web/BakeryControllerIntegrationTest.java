package com.qa.bakery.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bakery.domain.Bakery;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:bakery-schema.sql",
		"classpath:bakery-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BakeryControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Bakery testBakery = new Bakery(null, "Bienenstich", "none", "Torte");
		String testBakerynAsJSON = this.mapper.writeValueAsString(testBakery);

		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testBakerynAsJSON);

		Bakery testCreatedBakery = new Bakery(3, "Bienenstich", "none", "Torte");
		String testCreatedBakeryAsJSON = this.mapper.writeValueAsString(testCreatedBakery);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedBakeryAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");
		List<Bakery> testBakery = List.of(new Bakery(1, "Bienenstich", "none", "Torte"), new Bakery(2, "Croissant", "vegan", "Pastries"));
        String json = this.mapper.writeValueAsString(testBakery);
        ResultMatcher checkStatus = status().isOk();
        ResultMatcher checkBody = content().json(json);
        
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGet() throws Exception {
		Bakery savedBakery = new Bakery(1, "Bienenstich", "none", "Torte");
		String savedBakeryAsJSON = this.mapper.writeValueAsString(savedBakery);

		RequestBuilder req = get("/get/" + savedBakery.getId()).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(savedBakeryAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getByNameTest() throws Exception {
		RequestBuilder req = get("/getByName/Bienenstich");
		List<Bakery> testBakery = List.of(new Bakery(1, "Bienenstich", "none", "Torte"));
		String json = this.mapper.writeValueAsString(testBakery);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getByProductTest() throws Exception {
		RequestBuilder req = get("/getByProduct/Torte");
		List<Bakery> testBakery = List.of(new Bakery(1, "Bienenstich", "none", "Torte"));
		String json = this.mapper.writeValueAsString(testBakery);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getByDietaryTest() throws Exception {
		RequestBuilder req = get("/getByDietary/none");
		List<Bakery> testBakery = List.of(new Bakery(1, "Bienenstich", "none", "Torte"));
		String json = this.mapper.writeValueAsString(testBakery);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}


	@Test
	void testReplace() throws Exception {
		Bakery testBakery = new Bakery(null, "Bienenstich", "none", "Torte");
		String testBakeryAsJson = this.mapper.writeValueAsString(testBakery);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testBakeryAsJson);

		Bakery testCreatedBakery = new Bakery(1, "Bienenstich", "none", "Torte");
		String testCreatedBakeryAsJSON = this.mapper.writeValueAsString(testCreatedBakery);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testCreatedBakeryAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRemove() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());
	}

}
