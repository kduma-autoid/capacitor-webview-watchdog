import { registerPlugin } from '@capacitor/core';

import type { WebViewWatchDogPlugin } from './definitions';

const WebViewWatchDog = registerPlugin<WebViewWatchDogPlugin>(
  'WebViewWatchDog',
  {
    web: () => import('./web').then(m => new m.WebViewWatchDogWeb()),
  },
);

export * from './definitions';
export { WebViewWatchDog };
