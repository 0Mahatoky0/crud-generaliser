package util.exeption;

public class IncastableClassExeption extends Exception {
    private Class<?> class1;

    public IncastableClassExeption(Class<?> class1) {
        super("La classe " + class1.toString() + " est incastable.");
        this.class1 = class1;
    }

    public Class<?> getClass1() {
        return class1;
    }
}
