package de.swt.testing;

/**
 * Service that sends emails.
 */
public class EmailService {

    /**
     * Sends an email with the given parameters.
     *
     * @param to the recipient address
     * @param subject the email subject
     * @param body the email body
     * @return true if the email was sent
     */
    public boolean sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to + ": " + subject);
        return true;
    }
}
