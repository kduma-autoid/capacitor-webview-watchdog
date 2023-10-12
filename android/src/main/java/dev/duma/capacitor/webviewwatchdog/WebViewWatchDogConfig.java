package dev.duma.capacitor.webviewwatchdog;

import androidx.annotation.Nullable;

public class WebViewWatchDogConfig {
    private boolean launchWatchEnabled = true;
    private int launchWatchDuration = 10000;
    private String launchFailedHelpUrl = null;

    private boolean runtimeWatchEnabled = false;
    private int runtimeWatchDuration = 5000;
    private String runtimeFailedHelpUrl = null;

    public int getLaunchWatchDuration() {
        return launchWatchDuration;
    }

    public void setLaunchWatchDuration(int launchWatchDuration) {
        this.launchWatchDuration = launchWatchDuration;
    }

    public boolean isLaunchWatchEnabled() {
        return launchWatchEnabled;
    }

    public void setLaunchWatchEnabled(boolean launchWatchEnabled) {
        this.launchWatchEnabled = launchWatchEnabled;
    }

    @Nullable
    public String getLaunchFailedHelpUrl() {
        return launchFailedHelpUrl;
    }

    public void setLaunchFailedHelpUrl(String launchFailedHelpUrl) {
        this.launchFailedHelpUrl = launchFailedHelpUrl;
    }

    public boolean isRuntimeWatchEnabled() {
        return runtimeWatchEnabled;
    }

    public void setRuntimeWatchEnabled(boolean runtimeWatchEnabled) {
        this.runtimeWatchEnabled = runtimeWatchEnabled;
    }

    public int getRuntimeWatchDuration() {
        return runtimeWatchDuration;
    }

    public void setRuntimeWatchDuration(int runtimeWatchDuration) {
        this.runtimeWatchDuration = runtimeWatchDuration;
    }

    @Nullable
    public String getRuntimeFailedHelpUrl() {
        return runtimeFailedHelpUrl;
    }

    public void setRuntimeFailedHelpUrl(String runtimeFailedHelpUrl) {
        this.runtimeFailedHelpUrl = runtimeFailedHelpUrl;
    }
}
