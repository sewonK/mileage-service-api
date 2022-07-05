package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.PointResponse;
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
    public int updatePoints(String userId, int diffPoint) {
        User user = findById(userId);
        user.setPoint(user.getPoint() + diffPoint);
        userRepository.save(user);
        return user.getPoint();
    }

    @Override
    public PointResponse getUserPoint(String userId) {
        User user = findById(userId);
        return new PointResponse(userId, user.getPoint());
    }
}
