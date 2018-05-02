package org.cdp.skeleton.persistence.model;

public class Notification {

    private String subject;
    private String body;

    public final String getSubject() {
        return subject;
    }

    public final void setSubject(final String argSubject) {
        this.subject = argSubject;
    }

    public final String getBody() {
        return body;
    }

    public final void setBody(final String argBody) {
        this.body = argBody;
    }

    @Override
    public String toString() {
        return "Notification{"
                + "subject='" + subject + '\''
                + ", body='" + body + '\''
                + '}';
    }
}
