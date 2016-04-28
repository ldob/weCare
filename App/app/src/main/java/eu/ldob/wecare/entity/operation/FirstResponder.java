package eu.ldob.wecare.entity.operation;

import eu.ldob.wecare.entity.user.AUser;

public class FirstResponder {

    private AUser user;
    private EStatus status;

    private enum EStatus {
        ALARMED, ACCEPTED, INACTION, FINISHED, DOCUMENTED
    }
}
