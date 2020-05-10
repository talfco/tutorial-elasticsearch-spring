package net.cloudburo.poc.springhateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProfileController {
    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/profile")
    public HttpEntity<Profile> profile(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        Profile profile = new Profile(String.format(TEMPLATE, name));
        profile.add(linkTo(methodOn(ProfileController.class).profile(name)).withSelfRel());

        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
