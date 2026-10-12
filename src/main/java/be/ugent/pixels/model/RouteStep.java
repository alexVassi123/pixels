package be.ugent.pixels.model;

public class RouteStep {

    private String step;
    private String sign;

    public RouteStep(String step, String sign) {
        this.step = step;
        this.sign = sign;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String toString() {
        return step + " " + sign;
    }
}
