package quoter;

import lombok.Setter;

import java.util.List;

public class TalkingRobotImpl implements TalkingRobot {
    @Setter
    private List<Quoter> quoters;

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
