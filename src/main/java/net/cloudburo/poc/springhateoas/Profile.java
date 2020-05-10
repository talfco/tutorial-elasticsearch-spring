package net.cloudburo.poc.springhateoas;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile extends RepresentationModel<Profile> {

    private final String content;

    @JsonCreator
    public Profile(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
