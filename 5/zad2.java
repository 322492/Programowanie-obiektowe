import java.io.*;

abstract class Expression {
    public abstract int evaluate();

    public abstract String toString(); //przy wypisywaniu uzywam wielu nawiasow, aby bylo jasno widac ktore wyrazenia beda obliczane pierwsze
}

class Add extends Expression {
    Expression a, b;

    public Add(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate() {
        return a.evaluate() + b.evaluate();
    }

    public String toString() {
        return "(" + a.toString() + " + " + b.toString() + ")";
    }
}

class Distract extends Expression {
    Expression a, b;

    public Distract(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate() {
        return a.evaluate() - b.evaluate();
    }

    public String toString() {
        return "(" + a.toString() + " - " + b.toString() + ")";
    }
}

class Multiply extends Expression {
    Expression a, b;

    public Multiply(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate() {
        return a.evaluate() * b.evaluate();
    }

    public String toString() {
        return "(" + a.toString() + " * " + b.toString() + ")";
    }
}

class Const extends Expression {
    int a;

    public Const(int a) {
        this.a = a;
    }

    public int evaluate() {
        return this.a;
    }

    public String toString() {
        return Integer.toString(a);
    }
}

class Variable extends Expression {
    int wart;
    String zm;

    public Variable(String zm, int wart) {
        //jako ze moze byc wiele zmiennych zdecydowalem sie na podawanie razem z nazwa zmiennej od razu jej wartosci, ktora ma byc uzywana do obliczen
        this.wart = wart;
        this.zm = zm;
    }

    public int evaluate() {
        return wart;
    }

    public String toString() {
        return zm;
    }
}

public class zad2 {
    public static void main(String[] args) {
        Variable x = new Variable("x", 2);
        Variable y = new Variable("y", 55);
        Const eight = new Const(8);
        Const three = new Const(3);
        Expression e1 = new Multiply(x, eight);
        Expression e2 = new Add(x, new Multiply(x, new Add(x, new Multiply(x, new Const(1)))));
        System.out.println("e1 to: " + e1.toString() + " = " + e1.evaluate());
        System.out.println("e2 to: " + e2.toString() + " = " + e2.evaluate());
        System.out.println("stała three to: " + three.toString() + " = " + three.evaluate());
        System.out.println("zmienna y to: " + y.toString() + " = " + y.evaluate());
    }
}