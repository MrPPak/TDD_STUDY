package study.step02;

public class CarLocation {

    private int location;

    public CarLocation() {
        this.location = 0;
    }

    public int getLocation() {
        return this.location;
    }

    public void increaseLocation(int num) {
        if(num >= 4) {
            location++;
        }
    }

}
