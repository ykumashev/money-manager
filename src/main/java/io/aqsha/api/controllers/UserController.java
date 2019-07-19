package io.aqsha.api.controllers;

import java.util.Objects;

import io.aqsha.api.config.JwtTokenUtil;
import io.aqsha.api.models.JwtRequest;
import io.aqsha.api.models.JwtResponse;
import io.aqsha.api.models.User;
import io.aqsha.api.models.UserDTO;
import io.aqsha.api.repositories.UserRepository;
import io.aqsha.api.service.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @PostMapping(path = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    // delete user.
    @DeleteMapping(path = "/delete")
    public String deleteUser(@RequestBody String username) throws Exception{
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        return "User " + username + " deleted";
    }

    // Get user info
    @GetMapping(path="/get")
    public @ResponseBody User getUser(@RequestBody String username) {
        // This returns a JSON or XML with the users
        return userRepository.findByUsername(username);
    }

    //update user
    @PutMapping(path = "/update")
    public String updateUser(HttpServletRequest request) {
        //TO-DO
        //	// Updates user information
//	@PutMapping(path="/{id}")
//	public @ResponseBody String updateUser (@RequestParam(value = "name", required=false) final String name,
//											@RequestParam(value = "email", required=false) final String email,
////											@RequestParam(value = "newId", required=false) final long newId
//											@PathVariable long id) {
//		Optional<User> optionalUser = userRepository.findById(id);
//		if (!optionalUser.isPresent()) {
//			throw new UserNotFoundException("User with ID - " + id + " doesn't exist");
//		}
//		User user = optionalUser.get();
//
//		if (name != null) {
//			user.setName(name);
//		}
//
//		if (email != null) {
//			user.setEmail(email);
//		}
//
//		userRepository.save(user);
//		return "Updated";
//	}
        return null;
    }


}