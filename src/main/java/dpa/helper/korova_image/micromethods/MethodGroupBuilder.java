package dpa.helper.korova_image.micromethods;

import java.util.ArrayList;
import java.util.List;

public class MethodGroupBuilder {
    private List<MicroMethod> microMethods = new ArrayList<>();

    public void addMicroMethod(MicroMethod microMethod) {
        microMethods.add(microMethod);
    }

    public void executeAll() {
        for (MicroMethod microMethod : microMethods) {
            microMethod.execute();
        }
    }
}