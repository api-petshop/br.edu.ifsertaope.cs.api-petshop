package br.edu.ifsertaope.cs.api_petshop.product.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.product.command.*;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

@Service
public class ProductFacade {

    private final ProductRepository repository;

    public ProductFacade(ProductRepository repository) {
        this.repository = repository;
    }

    /* CREATE */
    public Product createProduct(Product product) {
        return new CreateProductCommand(repository, product).execute();
    }

    /* READ */
    public List<Product> listAllProducts() {
        return new ListProductsCommand(repository, null).execute();
    }

    public List<Product> listProductsByCategory(String category) {
        return new ListProductsCommand(repository, category).execute();
    }

    public Product findProductbyId(Long id) {
        return new FindProductByIdCommand(repository, id).execute();
    }

    /* UPDATE */
    public Product updateProduct(Long id, Product product) {
        return new UpdateProductCommand(repository, id, product).execute();
    }

    /* DELETE */
    public void deleteProduct(Long id) {
        new DeleteProductCommand(repository, id).execute();
    }

    /* STOCK */
    public Product updateStock(Long productId, Integer stock) {
        return new UpdateProductStockCommand(repository, productId, stock).execute();
    }

}
