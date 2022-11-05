package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String name,
                                                     @RequestParam(required = false) Long barcode) {
        List<Product> productList = new LinkedList<>();
        if(barcode != null) {
            Product product = productService.getProductByBarcode(barcode);
            productList.add(product);
        } else if (name != null) {
            productList = productService.getProductsByName(name);
        } else {
            productList = productService.getAll();
        }
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if(StringUtils.isAnyBlank(product.getName(), product.getLaboratory())
                || product.getBarcode() == null || product.getPrice() == null) {
            throw new IllegalArgumentException("Missing required parameters");
        }
        List<Product> listProduct = productService.getProductsByNameOrBarcode(product.getName(), product.getBarcode());
        if(!CollectionUtils.isEmpty(listProduct)) {
            throw new IllegalArgumentException("Product already exist");
        }
        product = productService.create(product);
        return ResponseEntity.created(null).body(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                 @PathVariable Long id) {
        product.setId(id);
        product = productService.update(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Product product = productService.getById(id);
        if(product != null) {
            productService.delete(product);
        } else {
            throw new EntityNotFoundException(String.format("Product id %s not found", id));
        }
        return ResponseEntity.ok().body(null);
    }

}
