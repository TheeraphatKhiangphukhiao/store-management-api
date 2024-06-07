package com.example.store.myapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class CustomersException extends BaseException {
	
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	public CustomersException(String code, HttpStatus status) {
		super("status." + code, status);
	}
	public static CustomersException emptyCustomer() {
		return new CustomersException("findCustomer.notFound", HttpStatus.BAD_REQUEST);
	}
}
