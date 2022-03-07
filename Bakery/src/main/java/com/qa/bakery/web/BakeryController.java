package com.qa.bakery.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bakery.domain.Bakery;
import com.qa.bakery.service.BakeryService;

@CrossOrigin
@RestController

public class BakeryController {

	private BakeryService service;

	@Autowired
	public BakeryController(BakeryService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")

	public ResponseEntity<Bakery> createBakery(@RequestBody Bakery b) {
		Bakery created = this.service.createBakery(b);
		ResponseEntity<Bakery> response = new ResponseEntity<Bakery>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Bakery>> getAllBakery() {
		return ResponseEntity.ok(this.service.getAllBakery());
	}

	@GetMapping("/get/{id}")
	public Bakery getBakery(@PathVariable Integer id) {
		return this.service.getBakery(id);
	}

	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Bakery>> getBakeryByName(@PathVariable String name) {
		List<Bakery> found = this.service.getBakeryByName(name);
		return ResponseEntity.ok(found);
	}

	@GetMapping("/getByProduct/{product}")
	public ResponseEntity<List<Bakery>> getBakeryByProduct(@PathVariable String product) {
		List<Bakery> found = this.service.getBakeryByProduct(product);
		return ResponseEntity.ok(found);
	}

	@GetMapping("/getByIsvegan/{bool}")
	public ResponseEntity<List<Bakery>> getBakeryByIsvegan(@PathVariable Boolean bool) {
		List<Bakery> found = this.service.getBakeryByIsvegan(bool);
		return ResponseEntity.ok(found);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Bakery> replaceBakery(@PathVariable Integer id, @RequestBody Bakery newBakery) {
		Bakery body = this.service.replaceBakery(id, newBakery);
		ResponseEntity<Bakery> response = new ResponseEntity<Bakery>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeBakery(@PathVariable Integer id) {
		this.service.removeBakery(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
