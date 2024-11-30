package dpa.helper.korova_image.micromethods.methods;

import dpa.helper.korova_image.micromethods.MicroMethod;

public class PrintWorld implements MicroMethod {
    @Override
    public void execute() {
        System.out.println("World");
    }
}