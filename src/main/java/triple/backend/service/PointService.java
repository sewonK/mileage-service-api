package triple.backend.service;

import triple.backend.dto.EventRequest;
import triple.backend.dto.PointResponse;

import javax.transaction.Transactional;

public interface PointService {
    @Transactional
    PointResponse handleEvent(EventRequest eventRequest);
}
