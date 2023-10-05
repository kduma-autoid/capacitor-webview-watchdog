export interface WebViewWatchDogPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
