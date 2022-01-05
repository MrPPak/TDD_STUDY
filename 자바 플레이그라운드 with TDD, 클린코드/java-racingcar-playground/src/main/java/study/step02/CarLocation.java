package study.step02;

public class CarLocation {

    private int location;

    public CarLocation() {
        this.location = 0;
    }

    public int getLocation() {
        return this.location;
    }

    public boolean canIncrease(int num) {
        if(num >= 4) {
            return true;
        }
        return false;
    }

    public void increaseLocation() {
        location++;
    }

}
