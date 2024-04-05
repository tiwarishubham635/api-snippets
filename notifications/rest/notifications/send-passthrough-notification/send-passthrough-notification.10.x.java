// NOTE: This example uses the next generation Twilio helper library - for more
// information on how to download and install this version, visit
// https://www.twilio.com/docs/libraries/java
import java.util.Arrays;
import java.util.List;
import com.twilio.Twilio;
import com.twilio.rest.notify.v1.service.Notification;

public class Example {
  // Get your Account SID and Auth Token from https://twilio.com/console
  // To set up environment variables, see http://twil.io/secure
  public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

  public static final String SERVICE_SID = System.getenv("TWILIO_SERVICE_SID");

  public static void main(String[] args) {
    // Initialize the client
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    List<String> toBindings = Arrays.asList(
    "{\"binding_type\":\"sms\",\"address\":\"+15555555555\"}",
    "{\"binding_type\":\"facebook-messenger\",\"address\":\"123456789123\"}");

    Notification notification = Notification
        .creator(SERVICE_SID)
        .setBody("Hello Bob")
        .setToBinding(toBindings)
        .create();

    System.out.println(notification.getSid());
  }
}