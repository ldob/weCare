package eu.ldob.wecare.service.rest;

public interface RestListener<TRequest> {

    void onRequestComplete(TRequest requestResult);

    void onError(Error error);
}