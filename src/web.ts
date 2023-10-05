import { WebPlugin } from '@capacitor/core';

import type { WebViewWatchDogPlugin } from './definitions';

export class WebViewWatchDogWeb
  extends WebPlugin
  implements WebViewWatchDogPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
