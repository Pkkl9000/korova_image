package dpa.helper.korova_image.micromethods.methods;

import dpa.helper.korova_image.micromethods.MicroMethod;

public class AddNumbers implements MicroMethod {
    private int a;
    private int b;

    public AddNumbers(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        System.out.println("Sum: " + (a + b));
    }
}