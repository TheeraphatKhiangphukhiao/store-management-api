package com.example.store.myapp.business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.myapp.model.Products;
import com.example.store.myapp.payload.ProductsPayload;
import com.example.store.myapp.service.ProductsService;

@Service
public class ProductsBusiness {
	@Autowired
	ProductsService productsService;
	
	public void saveProduct(ProductsPayload productsPayload) {
		Products products = new Products(
				productsPayload.getProduct_name(),
				productsPayload.getPrice());
		productsService.save(products);
	}
	public void updateProduct(long id, ProductsPayload productsPayload) {
		Products productsData = productsService.findById(id);
		productsData.setProduct_name(productsPayload.getProduct_name());
		productsData.setPrice(productsPayload.getPrice());
		
		productsService.save(productsData);
	}
}
