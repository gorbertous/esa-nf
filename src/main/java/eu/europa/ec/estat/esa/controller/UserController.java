package eu.europa.ec.estat.esa.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import eu.europa.ec.estat.esa.dto.UserDto;
import eu.europa.ec.estat.esa.model.User;
import eu.europa.ec.estat.esa.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	private static final String USER = "user";

	@GetMapping("/users")
	public String usersList(Model model) {
		return findPaginated(1, "id", "asc", model);
	}

	@GetMapping("/users/new")
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute(USER, userDto);
		return "new_user";
	}

	@GetMapping("/user/view/{id}")
	public String getUser(@PathVariable(value = "id") int id, Model model) {

		// get user from the service
		User user = userService.getUserById(id);

		// set user as a model attribute to pre-populate the form
		model.addAttribute(USER, user);
		return USER;
	}

	@PostMapping("/saveUser")
	public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult) {

		User existing = userService.findByEmail(userDto.getEmail());
		if (existing != null) {
			bindingResult.rejectValue("email", null, "Existing email error!");
		}

		if (bindingResult.hasErrors()) {
			return "new_user";
		}

		userService.registerNewUserAccount(userDto);

		return "redirect:/users?success";

	}

	@GetMapping("/users/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get user from the service
		User user = userService.getUserById(id);

		// set user as a model attribute to pre-populate the form
		model.addAttribute(USER, user);
		return "update_user";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") int id) {

		// call delete user method
		this.userService.deleteUserById(id);
		return "redirect:/users";
	}

	@GetMapping("/users/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 30;

		Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<User> listUsers = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listUsers", listUsers);
		return "users";
	}

}
