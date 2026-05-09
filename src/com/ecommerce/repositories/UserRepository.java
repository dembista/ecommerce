package repositories;

import java.util.Optional;

import models.User;

public interface UserRepository {
    Optional<User> findById(String id);
}
