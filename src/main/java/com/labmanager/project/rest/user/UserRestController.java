package com.labmanager.project.rest.user;


import com.labmanager.project.entity.member.Member;
import com.labmanager.project.entity.user.User;
import com.labmanager.project.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId){
        return userService.findById(userId);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUserById(@PathVariable int userId){
        return userService.deleteUserById(userId);
    }


    @PostMapping ("/user")
    public void createNewUser(@RequestBody CreateUserParam user){
        User user1 = user.getUser();
        user1.setMember(user.getMember());
        userService.save(user1);
    }

    @GetMapping("/user")
    public User getUserByEmail (@RequestParam("email") String email ){
        return userService.findByEmail(email);
    }

}

 class CreateUserParam {
    private User user;

    public CreateUserParam(User user, Member member) {
        this.user = user;
        this.member = member;
    }

    private Member member;

     public User getUser() {
         return user;
     }

     public void setUser(User user) {
         this.user = user;
     }

     public Member getMember() {
         return member;
     }

     public void setMember(Member member) {
         this.member = member;
     }
 }

