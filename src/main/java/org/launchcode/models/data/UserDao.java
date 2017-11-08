package org.launchcode.models.data;

import org.launchcode.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JosephT on 7/27/2017.
 */
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    User findByUid(int uid);

    List<User> findAll();
}
