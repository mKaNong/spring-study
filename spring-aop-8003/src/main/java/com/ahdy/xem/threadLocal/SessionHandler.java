package com.ahdy.xem.threadLocal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SessionHandler {

    public static ThreadLocal<Session> sessionThreadLocal = ThreadLocal.<Session>withInitial(() -> new Session());

    @Data
    public static class Session{
        private String id;
        private String user;
        private String status;
    }

    public String getUser() {
        return sessionThreadLocal.get().getUser();
    }

    public String getStatus() {
        return sessionThreadLocal.get().getStatus();
    }

    public void setStatus(String status) {
        sessionThreadLocal.get().setStatus(status);
    }
}
