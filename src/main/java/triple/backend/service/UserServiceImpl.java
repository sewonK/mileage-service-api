package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.UserResponse;
import triple.backend.entity.User;
import triple.backend.exception.UserNotFoundException;
import triple.backend.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User findById(String userId) {
        return userRepository.findById(UUID.fromString(userId)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserResponse saveUserById(String userId) {
        User user = User.builder().userId(UUID.fromString(userId)).build();
        userRepository.save(user);
        return new UserResponse(userId, user.getPoint());
    }

    @Override
    public int updatePoints(String userId, int diffPoint) {
        User user = findById(userId);
        user.setPoint(user.getPoint() + diffPoint);
        userRepository.save(user);
        return user.getPoint();
    }
}
