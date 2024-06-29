package org.x3codes.quadraticequations;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import org.x3codes.quadraticequations.databinding.ActivityMainBinding;

public class Equation extends BaseObservable {
    String a;
    String b;
    String c;
    ActivityMainBinding binding;

    public Equation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public Equation() {}

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view) {
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        double discriminant  = b * b - 4 * a * c;

        double x1, x2;
        if(discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            //  Display the result in the textview

            binding.textView.setText(String.format("X1 = %s; X2 = %s", x1, x2));
        } else if (discriminant < 0) {
            binding.textView.setText("No real roots (complex roots)");
        } else {
            x1 = (double) -b / (2 * a);
            binding.textView.setText(String.format("x = %s", x1));
        }
    }
}
