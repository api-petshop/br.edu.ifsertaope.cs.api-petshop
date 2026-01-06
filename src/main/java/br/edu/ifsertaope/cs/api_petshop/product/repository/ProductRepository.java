package br.edu.ifsertaope.cs.api_petshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.product.entity.product;

public interface ProductRepository extends JpaRepository<product, Long> {

}
