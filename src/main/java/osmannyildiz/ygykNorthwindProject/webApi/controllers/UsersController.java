package osmannyildiz.ygykNorthwindProject.webApi.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import osmannyildiz.coreProject.utilities.results.DataResult;
import osmannyildiz.coreProject.utilities.results.ErrorDataResult;
import osmannyildiz.coreProject.utilities.results.Result;
import osmannyildiz.coreProject.utilities.results.SuccessResult;
import osmannyildiz.ygykNorthwindProject.business.abstracts.IUserService;
import osmannyildiz.ygykNorthwindProject.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private IUserService userService;
	
	@Autowired
	public UsersController(IUserService userService) {
		this.userService = userService;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<String, String>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>(errors, "Lütfen doğrulama hatalarını düzeltip tekrar deneyin.");
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid User user) {
		DataResult<User> addResult = userService.add(user); 
		return ResponseEntity.ok(new SuccessResult(addResult.getMessage()));
	}

}
