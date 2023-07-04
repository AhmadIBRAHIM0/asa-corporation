package ahmad.io.asa_corporation.helpers;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class InputValidation {

    public InputValidation(Context context) {
    }

    public boolean isInputEditTextFilled(TextInputEditText editText, TextInputLayout inputLayout, String message) {
        String value = Objects.requireNonNull(editText.getText()).toString().trim();
        if (value.isEmpty()) {
            showError(inputLayout, message);
            return false;
        } else {
            clearError(inputLayout);
        }
        return true;
    }

    public boolean isInputEditTextEmail(TextInputEditText editText, TextInputLayout inputLayout, String message) {
        String value = Objects.requireNonNull(editText.getText()).toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            showError(inputLayout, message);
            return false;
        } else {
            clearError(inputLayout);
        }
        return true;
    }

    public boolean isInputEditTextMatches(TextInputEditText editText1, TextInputEditText editText2, TextInputLayout inputLayout, String message) {
        String value1 = Objects.requireNonNull(editText1.getText()).toString().trim();
        String value2 = Objects.requireNonNull(editText2.getText()).toString().trim();
        if (!value1.contentEquals(value2)) {
            showError(inputLayout, message);
            return false;
        } else {
            clearError(inputLayout);
        }
        return true;
    }

    private void showError(TextInputLayout inputLayout, String message) {
        inputLayout.setError(message);
        inputLayout.requestFocus();
    }

    private void clearError(TextInputLayout inputLayout) {
        inputLayout.setError(null);
    }

    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
