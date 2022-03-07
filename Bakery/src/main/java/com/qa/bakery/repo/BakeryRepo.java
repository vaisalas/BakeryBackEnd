package com.qa.bakery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.bakery.domain.Bakery;

@Repository
public interface BakeryRepo extends JpaRepository<Bakery, Integer> {

	List<Bakery> findByNameIgnoreCase(String name);

	List<Bakery> findByProductIgnoreCase(String product);

	List<Bakery> findByIsvegan(Boolean bool);

}
