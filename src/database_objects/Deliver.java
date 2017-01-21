package database_objects;

/**
 * Created by savch on 21.01.2017.
 * All rights is okey =)
 */
public class Deliver {
    private String timeDelivery;
    private String aboutDelivery;

    public void setTimeDelivery(String timeDelivery) {
        this.timeDelivery = timeDelivery;
    }

    public void setAboutDelivery(String aboutDelivery) {
        this.aboutDelivery = aboutDelivery;
    }

    public String getTimeDelivery() {

        return timeDelivery;
    }

    public String getAboutDelivery() {
        return aboutDelivery;
    }
}
