package com.kass.prueba_tecnica.services.interfaces;

import java.util.Optional;

import com.kass.prueba_tecnica.models.User;

public interface IUserService {

    public User save(User user);

    public Optional<User> findUserByUsername(String username);
}
