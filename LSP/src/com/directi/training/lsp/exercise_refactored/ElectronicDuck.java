package com.directi.training.lsp.exercise;

public class Duck {
    public void quack() {
        System.out.println("Quack...");
    }

    public void swim() {
        System.out.println("Swim...");
    }
}

package com.directi.training.lsp.exercise;

public class ElectronicDuck extends Duck {
    private boolean _on = false;

    @Override
    public void quack() {
        if (_on) {
            System.out.println("Electronic duck quack...");
        } else {
            System.out.println("Silent electronic duck...");
        }
    }

    @Override
    public void swim() {
        if (_on) {
            System.out.println("Electronic duck swims...");
        } else {
            System.out.println("Electronic duck is floating...");
        }
    }

    public void turnOn() {
        _on = true;
    }

    public void turnOff() {
        _on = false;
    }
}

package com.directi.training.lsp.exercise;

public class Pool {
    public void run() {
        Duck donaldDuck = new Duck();
        ElectronicDuck electricDuck = new ElectronicDuck();
        
        electricDuck.turnOff(); // Turn off the electronic duck
        
        quack(donaldDuck, electricDuck);
        swim(donaldDuck, electricDuck);
    }

    private void quack(Duck... ducks) {
        for (Duck duck : ducks) {
            duck.quack();
        }
    }

    private void swim(Duck... ducks) {
        for (Duck duck : ducks) {
            duck.swim();
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.run();
    }
}
