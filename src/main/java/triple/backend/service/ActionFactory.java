package triple.backend.service;

import triple.backend.enums.ActionType;

public interface ActionFactory {
    Action getAction(ActionType actionType);
}
