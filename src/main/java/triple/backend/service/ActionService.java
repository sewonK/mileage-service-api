package triple.backend.service;

import triple.backend.dto.EventRequest;
import triple.backend.enums.PointDetails;

public interface ActionService {
    int calculatePoints(EventRequest eventRequest);
    boolean checkCurrentReview(EventRequest eventRequest, PointDetails pointDetails);
}
