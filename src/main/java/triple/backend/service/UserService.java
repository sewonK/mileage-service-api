package triple.backend.service;

import triple.backend.dto.UserResponse;
import triple.backend.entity.User;

public interface UserService {

    User findById(String userId);

    UserResponse saveUserById(String userId);

    int updatePoints(String userId, int diffPoint);
}
