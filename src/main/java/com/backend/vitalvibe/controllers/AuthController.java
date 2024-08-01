package com.backend.vitalvibe.controllers;

import com.backend.vitalvibe.models.ERole;
import com.backend.vitalvibe.models.Role;
import com.backend.vitalvibe.models.User;
import com.backend.vitalvibe.payload.request.SigninRequest;
import com.backend.vitalvibe.payload.request.SignupRequest;
import com.backend.vitalvibe.security.jwt.JwtUtils;
import com.backend.vitalvibe.security.services.UserDetailsImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.backend.vitalvibe.payload.response.MessageResponse;
import com.backend.vitalvibe.payload.response.UserInfoResponse;
import com.backend.vitalvibe.repositories.RoleRepository;
import com.backend.vitalvibe.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    // logga in
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninRequest signinRequest, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        // jwt token utan cookie
        //String jwt = jwtUtils.generateJwtToken((authentication));

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // för jwt i cookie
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.SET_COOKIE);


        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        // jwt utan cookie
       /* return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));*/

        // jwt med cookie
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getThemeColor(),
                        roles));
    }

    // registrera en user
    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername((signupRequest.getUsername()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: username already exists!"));
        }
        if (userRepository.existsByEmail((signupRequest.getEmail()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email already exists!"));
        }


        // skapa userns konto
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()), signupRequest.getFirstName(), signupRequest.getLastName(),signupRequest.getAge(), signupRequest.getVo2max());

        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: roles is not found"));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
                        roles.add(adminRole);
                    }
                    case "mod" -> {
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
                        roles.add(modRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
                        roles.add(userRole);
                    }
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }

    // Logga ut
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        // Generera en ny cookie som är tom
        ResponseCookie jwtCookie = jwtUtils.getCleanJwtCookie();
        // Skicka med den tomma cookien till webbläsaren
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body("Logged out successfully");
    }
}
