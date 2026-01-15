package br.edu.ifsertaope.cs.api_petshop.product.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class UpdateProductCommand implements Command<Product> {

    private final ProductRepository repository;
    private final Long ProductId;
    private final Product updatedProduct;

    public UpdateProductCommand(ProductRepository repository, Long ProductId, Product updatedProduct) {
        this.repository = repository;
        this.ProductId = ProductId;
        this.updatedProduct = updatedProduct;
    }

    @Override
    public Product execute() {
        Product product = repository.findById(ProductId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());
        product.setCategory(updatedProduct.getCategory());

        return repository.save(product);
    }

}
