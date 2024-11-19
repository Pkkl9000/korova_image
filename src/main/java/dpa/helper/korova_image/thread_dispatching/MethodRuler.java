package dpa.helper.korova_image.thread_dispatching;

class MethodRuler {
    public boolean runMethodA = true;
    public boolean runMethodB = true;
    public boolean runMethodC = true;

    public void setRun(String methodName, boolean value) {
        switch (methodName) {
            case "methodA":
                runMethodA = value;
                break;
            case "methodB":
                runMethodB = value;
                break;
            case "methodC":
                runMethodC = value;
                break;
            default:
                System.out.println("Метод не найден: " + methodName);
        }
    }

    public void methodA() {
        if (runMethodA) {
            System.out.println("Метод A выполняется");
        } else {
            System.out.println("Метод A остановлен");
        }
    }

    public void methodB() {
        if (runMethodB) {
            System.out.println("Метод B выполняется");
        } else {
            System.out.println("Метод B остановлен");
        }
    }

    public void methodC() {
        if (runMethodC) {
            System.out.println("Метод C выполняется");
        } else {
            System.out.println("Метод C остановлен");
        }
    }
}