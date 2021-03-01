package com.deo.sarafan.service;

import com.deo.sarafan.entity.User;
import com.deo.sarafan.repo.UserDetailsRepo;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {
private final UserDetailsRepo userDetailsRepo;

    public ProfileService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }


    public User changeSubscription(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();

        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        } else subscribers.add(subscriber);
        return userDetailsRepo.save(channel);
    }

}
