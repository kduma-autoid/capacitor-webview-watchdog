package dev.duma.capacitor.webviewwatchdog;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "WebViewWatchDog")
public class WebViewWatchDogPlugin extends Plugin {
    private WebViewWatchDog watchDog;
    private WebViewWatchDogConfig config;

    @Override
    public void load() {
        config = getWebViewWatchDogConfig();
        watchDog = new WebViewWatchDog(getContext(), config);

        if(config.isLaunchWatchEnabled()) {
            watchDog.startOnLaunch(getActivity());
        }
    }

    private WebViewWatchDogConfig getWebViewWatchDogConfig() {
        WebViewWatchDogConfig config = new WebViewWatchDogConfig();

        config.setLaunchWatchDuration(
            getConfig()
                .getInt(
                    "launchWatchDuration",
                    config.getLaunchWatchDuration()
                )
        );

        config.setLaunchWatchEnabled(
            getConfig()
                .getBoolean(
                    "launchWatchEnabled",
                    config.isLaunchWatchEnabled()
                )
        );

        config.setLaunchFailedHelpUrl(
            getConfig()
                .getString(
                    "launchFailedHelpUrl",
                    config.getLaunchFailedHelpUrl()
                )
        );

        config.setRuntimeWatchDuration(
            getConfig()
                .getInt(
                    "runtimeWatchDuration",
                    config.getRuntimeWatchDuration()
                )
        );

        config.setRuntimeWatchEnabled(
            getConfig()
                .getBoolean(
                    "runtimeWatchEnabled",
                    config.isRuntimeWatchEnabled()
                )
        );

        config.setRuntimeFailedHelpUrl(
            getConfig()
                .getString(
                    "runtimeFailedHelpUrl",
                    config.getRuntimeFailedHelpUrl()
                )
        );

        return config;
    }

    @PluginMethod
    public void ping(PluginCall call) {
        watchDog.ping();

        call.resolve(new JSObject());
    }

    @PluginMethod
    public void start(PluginCall call) {
        watchDog.start(getActivity());

        call.resolve(new JSObject());
    }

    @PluginMethod
    public void stop(PluginCall call) {
        watchDog.stop();

        call.resolve(new JSObject());
    }
}
