package triple.backend.service;

import triple.backend.dto.EventRequest;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;

public interface PointHistoryService {
    int savePointHistory(EventRequest eventRequest, PointType pointType, PointDetails pointDetails);
    int getPoint(EventRequest eventRequest, PointDetails pointDetails);
}
