class MyClass {
  private String privateField;

  public MyClass(String privateField) {
    this.privateField = privateField;
  }

  public String getPrivateField() {
    return privateField;
  }
}
public class ReflectionExample {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    MyClass myInstance = new MyClass("privateField");

    Class<?> myClass = MyClass.class;

    Field privateField = myClass.getDecleare

}
