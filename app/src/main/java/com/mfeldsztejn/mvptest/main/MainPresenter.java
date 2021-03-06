package com.mfeldsztejn.mvptest.main;

import com.mfeldsztejn.mvptest.base.BasePresenter;
import com.mfeldsztejn.mvptest.repositories.HistoryRepository;

/**
 * Created by mfeldsztejn on 8/27/16.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private HistoryRepository historyRepository;

    public MainPresenter(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void calculate(float num1, float num2, String operation) {
        if (num2 == 0 && operation.equals("/")) {
            if (getView() != null)
                getView().setSnackBarError("No se puede dividir por 0!");
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
        if (getView() != null)
            getView().setResult(result);
        saveResult(num1, num2, operation, result);
    }

    public void showHistory() {
        if (getView() != null)
            getView().goToHistory();
    }

    private void saveResult(float num1, float num2, String operation, float result) {
        String value = num1 + operation + num2 + "=" + result;
        historyRepository.save(value);
    }
}
