import java.io.*;

abstract class Expression {

    public abstract int evaluate(int p); // w porownaniu do implementacji zadania 2. tutaj zmieniam troche specyfikacje
    // przyjmuje ze w wyrazeniach mam maksymalnie jedna zmienna i obliczenie
    // wartosci wyrazenia nastepuje dla podanej wartosci p

    public abstract String toString();

    public abstract Expression derivate();
}

class Add extends Expression {
    Expression a, b;

    public Add(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate(int p) {
        return a.evaluate(p) + b.evaluate(p);
    }

    public String toString() {
        return "(" + a.toString() + " + " + b.toString() + ")";
    }

    public Expression derivate() {
        if(a instanceof Const && b instanceof Const)return new Const(0);
        if(a instanceof Const)return b.derivate();
        if(b instanceof Const)return a.derivate();
        return new Add(a.derivate(), b.derivate());
    }
}

class Distract extends Expression {
    Expression a, b;

    public Distract(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate(int p) {
        return a.evaluate(p) - b.evaluate(p);
    }

    public String toString() {
        return "(" + a.toString() + " - " + b.toString() + ")";
    }

    public Expression derivate() {
        if(a instanceof Const && b instanceof Const)return new Const(0);
        if(a instanceof Const)return b.derivate();
        if(b instanceof Const)return a.derivate();
        return new Distract(a.derivate(), b.derivate());
    }
}

class Multiply extends Expression {
    Expression a, b;

    public Multiply(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate(int p) {
        return a.evaluate(p) * b.evaluate(p);
    }

    public String toString() {
        return "(" + a.toString() + " * " + b.toString() + ")";
    }

    public Expression derivate() {
        // (a*b)' = a'b + ab'
        if(a instanceof Const && b instanceof Const)return new Const(0);
        else if(a instanceof Const)return new Multiply(a, b.derivate());
        else if(b instanceof Const)return new Multiply(a.derivate(), b);

        Expression e1 = new Multiply(a.derivate(), b); // = a'b
        Expression e2 = new Multiply(a, b.derivate()); // = ab'

        return new Add(e1, e2);
    }
}

class Const extends Expression {
    int a;

    public Const(int a) {
        this.a = a;
    }

    public int evaluate(int p) {
        return this.a;
    }

    public String toString() {
        return Integer.toString(a);
    }

    public Expression derivate() {
        return new Const(0);
    }
}

class Variable extends Expression {
    String zm;

    public Variable(String zm) {
        this.zm = zm;
    }

    public int evaluate(int p) {
        return p;
    }

    public String toString() {
        return zm;
    }

    public Expression derivate() {
        return new Const(1);
    }
}

public class zad4 {
    public static void main(String[] args) {
        Variable x = new Variable("x");
        Const eight = new Const(8);
        Expression e1 = new Add(x, eight); // (x+8)
        Expression e2 = new Distract(x, new Const(1)); // (x-1)
        Expression e3 = new Multiply(e1, new Multiply(e2, new Const(2))); // (x+8)*(x-1)*2
        System.out.println("xprim to: " + x.derivate().toString());
        System.out
                .println("stała eight to: " + eight.toString() + ", a jej pochodna to: " + eight.derivate().toString());
        System.out.println("e3 to: " + e3.toString() + " (czyli 2x^2 + 14x - 16)");
        System.out
                .println("Pochodna e3 to: " + e3.derivate().toString() + " (po uproszczeniu zapisu jest to: 4x + 14)");
        System.out.println("e3(1) to: " + e3.evaluate(1));
        System.out.println("e3'(1) to: " + e3.derivate().evaluate(1));
    }
}