package vidal.falcon.ef.controllers;

import vidal.falcon.ef.dtos.DTOToken;
import vidal.falcon.ef.dtos.ClvfDTOUserLogin;
import vidal.falcon.ef.security.JwtUtilService;
import vidal.falcon.ef.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClvfLoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @PostMapping("/login")
    public ResponseEntity<DTOToken> authenticate(@RequestBody ClvfDTOUserLogin clvfUser) {
        // Verifica que el usuario y el password se encuentren en la base de datos
        //de la app
        // Verifica el password encriptado en la base de datos y se usa en la
        // autenticación.
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(clvfUser.getUserName(),
                        clvfUser.getPassword()));

        SecurityUser clvfSecurityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(
                clvfUser.getUserName());

        // Verifica el rol asignado al usuario
        if (!clvfSecurityUser.getAuthorities().iterator().next().getAuthority().equals(clvfUser.getRole())) {
            return new ResponseEntity<DTOToken>(HttpStatus.UNAUTHORIZED);
        }

        // Genera un token como resultado de la autenticación
        String clvfJwt = jwtUtilService.generateToken(clvfSecurityUser);
        return new ResponseEntity<DTOToken>(new DTOToken(clvfJwt), HttpStatus.OK);
    }
}
