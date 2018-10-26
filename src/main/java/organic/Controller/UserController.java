package organic.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import organic.DAO.UserReponsitory;
import organic.Model.User;
import organic.Service.ServiceResult;
import organic.Service.UserService;


@Controller
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /* ---------------- GET ALL USER ------------------------ */
    @GetMapping("")
    public ResponseEntity<ServiceResult> findAllCustomer() {
        return new ResponseEntity<ServiceResult>(userService.findAll(), HttpStatus.OK);
    }
    /* ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(userService.findById(id), HttpStatus.OK);
    }
    /* ---------------- CREATE NEW USER ------------------------ */
    @PostMapping("/add")
    public ResponseEntity<ServiceResult> create(@RequestBody User user) {
        return new ResponseEntity<ServiceResult>(userService.create(user), HttpStatus.OK);
    }

    /* ---------------- UPDATE USER ------------------------ */
    @PutMapping("/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody User user) {
        return new ResponseEntity<ServiceResult>(userService.update(user), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResult> delete(@RequestBody DeleteUserRequest request) {
        return new ResponseEntity<ServiceResult>(userService.delete(request.getId()), HttpStatus.OK);
    }
}
