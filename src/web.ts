import { WebPlugin } from '@capacitor/core';

import type { WebViewWatchDogPlugin } from './definitions';

export class WebViewWatchDogWeb
  extends WebPlugin
  implements WebViewWatchDogPlugin
{
  ping(): Promise<void> {
    return Promise.resolve(undefined);
  }

  start(): Promise<void> {
    return Promise.resolve(undefined);
  }

  stop(): Promise<void> {
    return Promise.resolve(undefined);
  }
}
