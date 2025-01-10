package app.controller;


import app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import app.model.User;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showAllUsers(ModelMap model) {

        List<User> allUsers = userService.getUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap model){

        User user = new User();
        model.addAttribute("userSave", user);

        return "user-info";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("userSave") User user ){

        userService.saveUser(user);

        return "redirect:/";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id,ModelMap model){

        User user = userService.getUser(id);
        model.addAttribute("userSave",user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id){

        userService.deleteUser(id);

        return "redirect:/";
    }
}





