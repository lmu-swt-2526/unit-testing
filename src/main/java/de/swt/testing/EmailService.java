package de.swt.testing;

import com.sun.nio.sctp.Notification;

/**
 * Service that sends emails.
 */
public class EmailService implements NotificationService {

    /**
     * Sends an email with the given parameters.
     *
     * @param to the recipient address
     * @param subject the email subject
     * @param body the email body
     * @return true if the email was sent
     */
    @Override
    public boolean notify(String to, String subject, String body) {
        System.out.println("Sending email to " + to + ": " + subject);
        return true;
    }
}
