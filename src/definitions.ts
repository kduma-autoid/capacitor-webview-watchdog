/// <reference types="@capacitor/cli" />

declare module '@capacitor/cli' {
  export interface PluginsConfig {
    /**
     * These config values are available:
     */
    WebViewWatchDog?: {
      /**
       * How long to wait for the ping on launch before showing the error message (in ms)
       *
       * @since 0.0.1
       * @default 5000
       * @example 10000
       */
      launchWatchDuration?: number;

      /**
       * Whether to auto start the watchdog on application launch.
       *
       * @since 0.0.1
       * @default true
       * @example true
       */
      launchWatchEnabled?: boolean;

      /**
       * If provided, on launch failure, the user will have ability to press help button to open this url.
       *
       * @since 0.0.1
       * @example "https://www.google.com/search?q=chrome+android+download"
       */
      launchFailedHelpUrl?: string|null;

      /**
       * How long to wait between the pings during runtime before showing the error message (in ms)
       *
       * @since 0.0.1
       * @default 5000
       * @example 1000
       */
      runtimeWatchDuration?: number;

      /**
       * Whether to auto start the watchdog after launch watchdog finishes
       *
       * @since 0.0.1
       * @default false
       * @example false
       */
      runtimeWatchEnabled?: boolean;

      /**
       * If provided, on runtime watchdog failure, the user will have ability to press help button to open this url.
       *
       * @since 0.0.1
       * @example "https://www.google.com/search?q=chrome+android+download"
       */
      runtimeFailedHelpUrl?: string|null;
    };
  }
}

export interface WebViewWatchDogPlugin {
  /**
   * Ping the watchdog.
   *
   * @since 0.0.1
   */
  ping(): Promise<void>;

  /**
   * Start the watchdog.
   *
   * @since 0.0.1
   */
  start(): Promise<void>;

  /**
   * Stops the watchdog.
   *
   * @since 0.0.1
   */
  stop(): Promise<void>;
}
