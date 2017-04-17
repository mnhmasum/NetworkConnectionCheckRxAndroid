package com.example.nazmul.networkchecker;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {
    public RxBus() {
    }

   /* private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }*/

    PublishSubject<String> stringBus = PublishSubject.create();

    public void send(String s) {
        stringBus.onNext(s);
    }

    public Observable<String> toObserverable() {
        return stringBus;
    }

    public boolean hasObservers() {
        return stringBus.hasObservers();
    }
}
