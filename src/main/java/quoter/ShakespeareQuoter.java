package quoter;

import lombok.Setter;

public class ShakespeareQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
