# Presentations site

HTML slide decks, built with [Astro](https://astro.build). One shared design
system and slide runtime; each talk is a single MDX file.

## Run

```bash
cd site
pnpm install    # first time only
pnpm dev        # open the printed localhost URL
```

`pnpm build` produces a static site in `dist/`; `pnpm preview` serves it.

## Add a talk

1. Create `src/talks/my-talk.mdx`.
2. Fill in the frontmatter:

   ```yaml
   ---
   title: "My Talk"
   date: 2026-08-01
   tags: [java, spring]
   description: "One-line summary shown on the index page."
   draft: false   # set true to hide it from the index and routing
   ---
   ```

3. Write slides using the components below. No imports needed — they're
   available in every deck. The talk appears on the home page and at
   `/talks/my-talk` automatically.

## Present

- **← → / Space / click** — next or previous slide
- **F** — toggle fullscreen
- **Home / End** — jump to first / last slide
- The URL tracks the slide number (`#5`), so you can resume mid-deck.

## Slide components

| Component | Purpose |
|---|---|
| `<Title kicker subtitle>` | Opening / section title |
| `<Slide align="start\|center">` | Freeform slide; write Markdown inside |
| `<Code code lang title mark>` | Highlighted code; `mark="2-4,7"` highlights lines |
| `<Image src alt title contain>` | Image slide |
| `<TwoColumn title>` | Two columns via `slot="left"` / `slot="right"` |
| `<Quote cite>` | Full-bleed quote / big statement |
| `<TierList title tiers>` | S/A/B/C/D/F tier list |

See `src/talks/example.mdx` for a worked example of every one.

## Images

Put per-talk assets in `public/talks/<talk>/` and reference them by absolute
URL, e.g. `<Image src="/talks/my-talk/diagram.png" alt="..." />`.

## Design

All visual styling lives in `src/styles/theme.css` as CSS custom properties,
encoding the rules in [`../impeccable-design-rules.md`](../impeccable-design-rules.md).
Reskin a deck by overriding the custom properties (e.g. change `--brand-h`);
don't fork the stylesheet per talk. The slide runtime (navigation, fullscreen,
progress) is `src/runtime/deck.js` + `deck.css` — about 100 lines, no
dependencies.
