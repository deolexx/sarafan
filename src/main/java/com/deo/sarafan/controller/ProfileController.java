package com.deo.sarafan.controller;

import com.deo.sarafan.entity.User;
import com.deo.sarafan.entity.Views;
import com.deo.sarafan.service.ProfileService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
public class ProfileController {
    private final ProfileService profileService;
@Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping("{id}")
    @JsonView(Views.FullProfile.class)
    public User get(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("change-subscription/{channelId}")
    @JsonView(Views.FullProfile.class)
    public User changeSubscription(
    @AuthenticationPrincipal User subscriber,
    @PathVariable("channelId") User channel
    ) {

        if (subscriber.equals(channel)) {
            return channel;
        }
        else
            return profileService.changeSubscription(channel, subscriber);

    }



}
