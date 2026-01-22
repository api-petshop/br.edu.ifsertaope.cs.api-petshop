package br.edu.ifsertaope.cs.api_petshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
