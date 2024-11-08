package com.manage.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.emp.entity.Employee;
import com.manage.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    // private final AuthenticationManager authenticationManager;
    // private final JwtUtil jwtUtil;
    // private final UserDetailService userDetailservice;
    
    // @Autowired
    // public EmployeeController(EmployeeService employeeService, AuthenticationManager authenticationManager,
    // JwtUtil jwtUtil, UserDetailService userDetailservice) {
    // this.employeeService = employeeService;
    // this.authenticationManager = authenticationManager;
    // this.jwtUtil = jwtUtil;
    // this.userDetailservice = userDetailservice;
    // }
    
    
    @PostMapping("/add")
    public ResponseEntity<Employee> addemployee(@RequestBody Employee employee){
        Employee employee1=this.employeeService.addemployee(employee);
        return ResponseEntity.ok(employee1);
    }    
//    @PostMapping("/login")
//     public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
//         // logger.info("before authentication");
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
//     //    logger.info("Successfully autheticated");
//       if (authentication.isAuthenticated()) {
//             // logger.info("Successfully autheticated");
//             Map<String, String> authResponse = new HashMap<>();
//             User user = (User) authentication.getPrincipal();
//         String jwtToken = this.jwtUtil.generateToken(user);
//             authResponse.put("token", jwtToken);
                    
//             return new ResponseEntity<>(authResponse, HttpStatus.OK);
//         }
//         throw new UsernameNotFoundException("Invalid credentials");
//     }

    }
    
    

