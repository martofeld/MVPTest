package com.mfeldsztejn.mvptest.main;

import com.mfeldsztejn.mvptest.base.BasePresenter;

/**
 * Created by mfeldsztejn on 8/27/16.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public void calculate(float num1, float num2, String operation) {
        if (num2 == 0 && operation.equals("/")) {
            view.setSnackBarError("No se puede dividir por 0!");
            return;
        }
        float result = 0;
        switch (operation) {
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        view.setResult(result);
    }
}
