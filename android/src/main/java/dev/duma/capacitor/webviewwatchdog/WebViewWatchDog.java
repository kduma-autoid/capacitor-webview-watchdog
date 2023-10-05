package dev.duma.capacitor.webviewwatchdog;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewWatchDog {
    private Context context;
    private WebViewWatchDogConfig config;

    private boolean running = false;
    private boolean pinged = false;
    private boolean launch_phase = false;

    public WebViewWatchDog(Context context, WebViewWatchDogConfig config) {
        this.context = context;
        this.config = config;
    }

    public void startOnLaunch(final AppCompatActivity activity) {
        if(running)
            return;

        startDelayHandler(activity, true);
    }

    public void start(final AppCompatActivity activity) {
        if(running)
            return;

        startDelayHandler(activity, false);
    }

    public void stop() {
        if(!running)
            return;

        running = false;
    }

    public void ping() {
        pinged = true;

        if (!launch_phase) return;

        if(config.isRuntimeWatchEnabled()) return;

        running = false;
    }

    private void startDelayHandler(AppCompatActivity activity, boolean launch) {
        running = true;
        pinged = false;
        launch_phase = launch;

        activity.runOnUiThread(
            () -> {
                new Handler(context.getMainLooper())
                    .postDelayed(
                        () -> {
                            if(!pinged && running) {
                                showAlert(activity, launch);
                            } else if(!launch && running || launch && config.isRuntimeWatchEnabled()) {
                                startDelayHandler(activity, false);
                            } else {
                                running = false;
                            }

                            pinged = false;
                        },
                        launch ? config.getLaunchWatchDuration() : config.getRuntimeWatchDuration()
                    );
            }
        );
    }

    private void showAlert(AppCompatActivity activity, boolean launch) {
        activity.runOnUiThread(
            () -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setCancelable(false)
                    .setTitle(R.string.header)
                    .setMessage(launch ? R.string.app_not_responding_on_launch : R.string.app_not_responding)
                    .setPositiveButton(R.string.wait_button, (dialog, which) -> {
                        startDelayHandler(activity, launch);
                    })
                    .setNegativeButton(R.string.stop_button, (dialog, which) -> {
                        activity.finishAffinity();
                    });

                String url = launch ? config.getLaunchFailedHelpUrl() : config.getRuntimeFailedHelpUrl();
                if(url != null) {
                    builder = builder.setNeutralButton(R.string.help_button, (dialog, which) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        try {
                            context.startActivity(intent);
                            if(launch) {
                                activity.finishAffinity();
                            } else {
                                startDelayHandler(activity, launch);
                            }
                        } catch(ActivityNotFoundException e) {
                            new AlertDialog.Builder(context)
                                .setTitle(R.string.help_message_title)
                                .setMessage(String.format(activity.getResources().getString(R.string.help_message_content), url))
                                .setNegativeButton(android.R.string.ok, (d, w) -> {
                                    if(launch) {
                                        activity.finishAffinity();
                                    } else {
                                        startDelayHandler(activity, launch);
                                    }
                                })
                                .show();
                        }
                    });
                }

                builder.show();
            }
        );
    }
}
