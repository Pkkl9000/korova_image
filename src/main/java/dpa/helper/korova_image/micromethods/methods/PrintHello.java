package dpa.helper.korova_image.micromethods.methods;

import dpa.helper.korova_image.micromethods.MicroMethod;

public class PrintHello implements MicroMethod {
    @Override
    public void execute() {
        System.out.println("Hello");
    }
}
