interface Window {
  void createWindow();
}

class MacWindow implements Window {
  public void createWindow() {
    System.out.println("MacWindow");
  }
}

class LinuxWindow implements Window {
  public void createWindow() {
    System.out.println("LinuxWindow");
  }
}

interface Button {
  void createButton();
}

class MacButton implements Button {
  public void createButton() {
    System.out.println("MacButton");
  }
}

class LinuxButton implements Button {
  public void createButton() {
    System.out.println("LinuxButton");
  }
}

interface GuiFactory {
  Window createWindow();

  Button createButton();
}

class MacFactory implements GuiFactory {
  public Window createWindow() {
    return new MacWindow();
  }

  public Button createButton() {
    return new MacButton();
  }
}

class LinuxFactory implements GuiFactory {
  public Window createWindow() {
    return new LinuxWindow();
  }

  public Button createButton() {
    return new LinuxButton();
  }
}

class AbstractFactoryPattern {
  public static void main(String[] args) {
    GuiFactory factory = new MacFactory();

    Window window = factory.createWindow();
    Button button = factory.createButton();

    window.createWindow();
    button.createButton();
  }
}