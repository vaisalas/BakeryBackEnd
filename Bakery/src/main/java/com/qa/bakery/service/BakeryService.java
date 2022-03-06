package com.qa.bakery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.bakery.domain.Bakery;

@Service
public class BakeryService {

	private List<Bakery> bakery = new ArrayList<>();

	public Bakery createBakery(Bakery b) {
		this.bakery.add(b);
		Bakery created = this.bakery.get(this.bakery.size() - 1);
		return created;
	}

	public List<Bakery> getAllBakery() {
		return this.bakery;
	}

	public Bakery getBakery(Integer id) {
		return this.bakery.get(id);
	}

	public Bakery replaceBakery(Integer id, Bakery newBakery) {
		Bakery body = this.bakery.set(id, newBakery);
		return body;
	}

	public void removeBakery(@PathVariable Integer id) {
		this.bakery.remove(id.intValue());
	}

}
