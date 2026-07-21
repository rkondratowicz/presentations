import { defineCollection, z } from 'astro:content';
import { glob } from 'astro/loaders';

// Every deck is one .mdx file in src/talks/. Add a file -> it appears on the
// index page and gets its own route automatically. That's the whole workflow.
const talks = defineCollection({
  loader: glob({ pattern: '**/*.mdx', base: './src/talks' }),
  schema: z.object({
    title: z.string(),
    date: z.coerce.date(),
    tags: z.array(z.string()).default([]),
    description: z.string().optional(),
    draft: z.boolean().default(false),
  }),
});

export const collections = { talks };
