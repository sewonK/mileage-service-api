package triple.backend.service.user;

import triple.backend.dto.PointResponse;
import triple.backend.entity.User;

public interface UserService {

    User findById(String userId);

    int updatePoints(String userId, int diffPoint);

    PointResponse getUserPoint(String userId);
}
