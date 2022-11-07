package triple.backend.service.action;

import triple.backend.dto.EventRequest;

public interface ActionService {
    int calculatePoints(EventRequest eventRequest);
}
