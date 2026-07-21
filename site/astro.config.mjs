// @ts-check
import { defineConfig } from 'astro/config';
import mdx from '@astrojs/mdx';

// https://astro.build/config
export default defineConfig({
  integrations: [mdx()],
  markdown: {
    shikiConfig: {
      // Dark theme reads well projected in a dim room; see the scene note in theme.css.
      theme: 'github-dark',
      wrap: false,
    },
  },
});
