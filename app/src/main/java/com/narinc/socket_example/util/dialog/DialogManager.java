package com.narinc.socket_example.util.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public interface DialogManager {
    Snackbar showSnackBar(View view, @StringRes int errorMessage, Throwable t,
                          @StringRes int actionLabel, View.OnClickListener clickListener);

    Snackbar showSnackBar(View view, @StringRes int errorMessage, String error,
                          @StringRes int actionLabel, View.OnClickListener clickListener);

    Snackbar showSnackBar(View view, @StringRes int message,
                          @StringRes int actionLabel,
                          View.OnClickListener clickListener);

    Snackbar showSnackBar(View view, String message,
                          @StringRes int actionLabel,
                          View.OnClickListener clickListener);

    Snackbar showSnackBar(View view, String message,
                          @StringRes int actionLabel, int actionTextColor,
                          View.OnClickListener clickListener);

    void showErrorDialog(Context context, @StringRes int errorMessage, String error);

    void showErrorDialog(Context context, @StringRes int errorMessage, List<String> errors);

    void showErrorDialog(Context context, String errorMessage, String error);

    void showErrorDialog(final Context context, final String errorMessage);

    void showMessageDialog(final Context context, final String message, final String title, DialogInterface.OnClickListener listener);

    void showErrorDialog(final Context context, final String errorMessage,
                         final int resIdPosButton, final DialogInterface.OnClickListener posListener,
                         final int resIdNegButton, final DialogInterface.OnClickListener negListener);

    void showErrorDialog(final Context context, final String title, final String errorMessage,
                         final int resIdPosButton, final DialogInterface.OnClickListener posListener,
                         final int resIdNegButton, final DialogInterface.OnClickListener negListener);

    void showErrorDialog(final Context context, final String errorMessage,
                         final int resIdPosButton, final DialogInterface.OnClickListener posListener);

    Dialog showProgress(final Dialog dialog);

    void hideProgress(Dialog dialog);

    void hideKeyboard(Activity activity);

    void hideKeyboard(Activity activity, View view);

    void showKeyboard(Activity activity, EditText editText);

    void showKeyboard(Activity activity, SearchView searchView);
}
