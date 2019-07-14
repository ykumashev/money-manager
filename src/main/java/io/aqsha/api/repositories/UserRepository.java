package io.aqsha.api.repositories;

import org.springframework.data.repository.CrudRepository;

import io.aqsha.api.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}