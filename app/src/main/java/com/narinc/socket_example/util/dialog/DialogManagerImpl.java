package com.narinc.socket_example.util.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.narinc.socket_example.R;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DialogManagerImpl implements DialogManager {

    private static final String NO_CONNECTION_ERROR = "Connection failed. Please check your internet connection.";
    private static final String NO_RESPONSE_TIMEOUT = "No response received within reply timeout.";
    private static Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @Inject
    public DialogManagerImpl() {

    }

    public Snackbar showSnackBar(View view, @StringRes int errorMessage, Throwable t,
                                 @StringRes int actionLabel, View.OnClickListener clickListener) {
        String error = (t == null) ? "" : t.getMessage();
        boolean noConnection = NO_CONNECTION_ERROR.equals(error);
        if (error != null) {
            boolean timeout = error.startsWith(NO_RESPONSE_TIMEOUT);
            if (noConnection || timeout) {
                return showSnackBar(view, R.string.no_internet_connection, actionLabel, clickListener);
            } else if (errorMessage == 0) {
                return showSnackBar(view, error, actionLabel, clickListener);
            } else if (error.equals("")) {
                return showSnackBar(view, errorMessage, view.getContext().getString(R.string.no_internet_connection), actionLabel, clickListener);
            } else {
                return showSnackBar(view, errorMessage, error, actionLabel, clickListener);
            }
        } else
            return showSnackBar(view, errorMessage, actionLabel, clickListener);
    }

    public Snackbar showSnackBar(View view, @StringRes int errorMessage, String error,
                                 @StringRes int actionLabel, View.OnClickListener clickListener) {
        String errorMessageString = view.getContext().getString(errorMessage);
        return showSnackBar(view, errorMessageString, actionLabel, clickListener);
    }

    public Snackbar showSnackBar(View view, @StringRes int message,
                                 @StringRes int actionLabel,
                                 View.OnClickListener clickListener) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(actionLabel, clickListener);
        snackbar.show();
        return snackbar;
    }

    public Snackbar showSnackBar(View view, String message,
                                 @StringRes int actionLabel,
                                 View.OnClickListener clickListener) {
        Snackbar snackbar = Snackbar.make(view, message.trim(), Snackbar.LENGTH_LONG);
        if (clickListener != null) {
            snackbar.setAction(actionLabel, clickListener);
        }
        snackbar.show();
        return snackbar;
    }

    public Snackbar showSnackBar(View view, String message,
                                 @StringRes int actionLabel, int actionTextColor,
                                 View.OnClickListener clickListener) {
        Snackbar snackbar = Snackbar.make(view, message.trim(), Snackbar.LENGTH_LONG);
        if (clickListener != null) {
            snackbar.setAction(actionLabel, clickListener);
            snackbar.setActionTextColor(actionTextColor);
        }
        snackbar.show();
        return snackbar;
    }

    public void showErrorDialog(Context context, @StringRes int errorMessage, String error) {
        showErrorDialog(context, context.getString(errorMessage), error);
    }

    public void showErrorDialog(Context context, @StringRes int errorMessage, List<String> errors) {
        showErrorDialog(context, context.getString(errorMessage), errors.toString());
    }

    public void showErrorDialog(Context context, String errorMessage, String error) {
        showErrorDialog(context, String.format("%s: %s", errorMessage, error));
    }

    public void showErrorDialog(final Context context, final String errorMessage) {
        mainThreadHandler.post(() -> new AlertDialog.Builder(context)
                .setTitle(R.string.error)
                .setMessage(errorMessage)
                .create()
                .show());
    }

    public void showMessageDialog(final Context context, final String message, final String title, DialogInterface.OnClickListener listener) {
        mainThreadHandler.post(() -> new MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, listener)
                .create()
                .show());
    }

    public void showErrorDialog(final Context context, final String errorMessage,
                                final int resIdPosButton, final DialogInterface.OnClickListener posListener,
                                final int resIdNegButton, final DialogInterface.OnClickListener negListener) {
        mainThreadHandler.post(() -> new MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
                .setMessage(errorMessage)
                .setPositiveButton(resIdPosButton, posListener)
                .setNegativeButton(resIdNegButton, negListener)
                .create()
                .show());
    }

    public void showErrorDialog(final Context context, final String title, final String errorMessage,
                                final int resIdPosButton, final DialogInterface.OnClickListener posListener,
                                final int resIdNegButton, final DialogInterface.OnClickListener negListener) {
        mainThreadHandler.post(() -> new MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
                .setTitle(title)
                .setMessage(errorMessage)
                .setPositiveButton(resIdPosButton, posListener)
                .setNegativeButton(resIdNegButton, negListener)
                .create()
                .show());
    }

    public void showErrorDialog(final Context context, final String errorMessage,
                                final int resIdPosButton, final DialogInterface.OnClickListener posListener) {
        mainThreadHandler.post(() -> new MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
                .setMessage(errorMessage)
                .setPositiveButton(resIdPosButton, posListener)
                .create()
                .show());
    }

    public Dialog showProgress(Dialog dialog) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_progress_dialog);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        return dialog;
    }

    public void hideProgress(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void hideKeyboard(Activity activity, View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showKeyboard(Activity activity, EditText editText) {
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    public void showKeyboard(Activity activity, SearchView searchView) {
        searchView.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT);
    }
}
