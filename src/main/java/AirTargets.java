/**
 * Created by Asus on 24.04.2017.
 */
public class AirTargets {
    private String airtarget_name;
    private int target_id;
    private int min_destination;
    private int max_destination;
    private int min_hight;
    private int max_hight;
    private int min_speed;
    private int max_speed;
    private int life_time;
    private int registr_app;
    private int min_APR;
    private int max_APR;
    private int cost;

    public AirTargets(int target_id, String airtarget_name, int min_destination, int max_destination, int min_hight, int max_hight, int min_speed, int max_speed, int life_time, int registr_app, int min_APR, int max_APR, int cost) {
        this.target_id = target_id;
        this.airtarget_name = airtarget_name;
        this.min_destination = min_destination;
        this.max_destination = max_destination;
        this.min_hight = min_hight;
        this.max_hight = max_hight;
        this.min_speed = min_speed;
        this.max_speed = max_speed;
        this.life_time = life_time;
        this.registr_app = registr_app;
        this.min_APR = min_APR;
        this.max_APR = max_APR;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "AirTargets: ["
                + target_id + "\t"
                + airtarget_name + "\t"
                + min_destination + "\t"
                + max_destination + "\t"
                + min_hight + "\t"
                + max_hight + "\t"
                + min_speed + "\t"
                + max_speed + "\t"
                + life_time + "\t"
                + registr_app + "\t"
                + min_APR + "\t"
                + max_APR + "\t"
                + cost +

                "]";
    }
}
