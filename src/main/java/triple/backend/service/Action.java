package triple.backend.service;

import triple.backend.dto.EventRequest;

public abstract class Action {
    abstract int calculatePoints(EventRequest eventRequest);
    abstract void Do(EventRequest eventRequest);
}
