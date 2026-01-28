package de.swt.testing;

public interface NotificationService {

    /**
     * Sends a notification with the given parameters.
     *
     * @param to the recipient
     * @param subject the message subject
     * @param body the message body
     * @return true if the notification was sent successfully
     */
    boolean notify(String to, String subject, String body);
}
