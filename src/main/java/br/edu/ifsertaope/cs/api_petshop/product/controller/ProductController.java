package br.edu.ifsertaope.cs.api_petshop.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.facade.ProductFacade;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductFacade facade;

    public ProductController(ProductFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return facade.createProduct(product);
    }

    @GetMapping
    public List<Product> listAll(
            @RequestParam(required = false) String category) {
        if (category != null) {
            return facade.listProductsByCategory(category);
        }
        return facade.listAllProducts();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return facade.findProductbyId(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return facade.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.deleteProduct(id);
    }

    @PatchMapping("/{id}/stock")
    public Product updateStock(@PathVariable Long id, @RequestParam Integer stock) {
        return facade.updateStock(id, stock);
    }

}
