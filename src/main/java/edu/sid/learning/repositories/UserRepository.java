package edu.sid.learning.repositories;

import edu.sid.learning.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository extends Repository<User, Integer> {
}
