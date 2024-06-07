package com.example.store.myapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ProductsException extends BaseException {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductsException(String code, HttpStatus status) {
		super("status." + code, status);
	}
	public static ProductsException emptyProduct() {
		return new ProductsException("findProduct.notFound", HttpStatus.BAD_REQUEST);
	}
}
