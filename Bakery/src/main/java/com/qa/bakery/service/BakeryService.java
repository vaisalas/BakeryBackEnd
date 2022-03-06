package com.qa.bakery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.bakery.domain.Bakery;
import com.qa.bakery.repo.BakeryRepo;

@Service
public class BakeryService {

	private BakeryRepo repo;

	@Autowired
	public BakeryService(BakeryRepo repo) {
		super();
		this.repo = repo;
	}

	public Bakery createBakery(Bakery b) {
		Bakery created = this.repo.save(b);
		return created;
	}

	public List<Bakery> getAllBakery() {
		return this.repo.findAll();
	}

	public Bakery getBakery(Integer id) {
		Optional<Bakery> found = this.repo.findById(id);
		return found.get();
	}

	public Bakery replaceBakery(Integer id, Bakery newBakery) {
		Bakery existing = this.repo.findById(id).get();

		existing.setName(newBakery.getName());
		existing.setIsvegan(newBakery.getIsvegan());
		existing.setProduct(newBakery.getProduct());
		Bakery updated = this.repo.save(existing);
		return updated;
	}

	public void removeBakery(@PathVariable Integer id) {
		this.repo.deleteById(id);
	}

}
