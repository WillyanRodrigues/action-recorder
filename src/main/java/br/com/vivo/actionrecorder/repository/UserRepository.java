package br.com.vivo.actionrecorder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.actionrecorder.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
