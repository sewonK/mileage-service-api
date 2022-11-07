package triple.backend.service.pointHistory;

import triple.backend.dto.EventRequest;
import triple.backend.enums.PointDetails;
import triple.backend.enums.PointType;

public interface PointHistoryService {
    int savePointHistory(EventRequest eventRequest, PointType pointType, PointDetails pointDetails);
    Long getPoint(EventRequest eventRequest, PointDetails pointDetails);
}
