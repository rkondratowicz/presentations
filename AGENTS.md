# AGENTS.md

Guidance for AI agents working in this repo. Read this before touching
anything under `site/`.

## What this repo is

A collection of conference talks. The **live, actively-developed system is
`site/`** — an Astro app that renders HTML slide decks. Everything else at
the repo root (`clean_hexagonal_onion/`, `structured_logging/`,
`lombok_tier_list/`, `why_i_didnt_want_to_give_this_presentation/`) is
per-talk source material (code samples, images, and legacy `.pptx`/`.pdf`
decks) — not part of the `site/` build. Don't assume they follow the same
conventions as `site/`.

## Quick start

```bash
cd site
pnpm install   # first time only
pnpm dev       # start the dev server
pnpm build     # static output to dist/
```

## The core model — read this first

**One talk = one `.mdx` file in `site/src/talks/`.** That's the entire
authoring workflow. Adding a file there automatically:
- registers the talk in the `talks` content collection ([content.config.ts](site/src/content.config.ts)),
- gives it a route at `/talks/<filename>`,
- lists it on the home page (unless `draft: true`).

Do **not** split a single talk's slides across multiple files. Slide order
is the file's top-to-bottom order — that's deliberate, keep it that way.
See [example.mdx](site/src/talks/example.mdx) as the canonical worked example
(copy it to start a new talk).

Frontmatter schema (enforced by Zod in `content.config.ts`):
```yaml
---
title: "My Talk"
date: 2026-08-01
tags: [java, spring]
description: "One-line summary shown on the index page."
draft: false   # true hides it from the index and routing
---
```

## Slide components

Available in every `.mdx` file **with no imports** (injected globally by
[pages/talks/[slug].astro](site/src/pages/talks/[slug].astro) via the
`slideComponents` map):

| Component | Purpose |
|---|---|
| `<Title kicker subtitle>` | Opening / section title |
| `<Slide align="start\|center">` | Freeform slide; Markdown inside |
| `<Code code lang title mark>` | Highlighted code; `mark="2-4,7"` highlights lines |
| `<Image src alt title contain>` | Image slide |
| `<TwoColumn title>` | Two columns via `slot="left"` / `slot="right"` |
| `<Quote cite>` | Full-bleed quote / big statement |
| `<TierList title tiers>` | S/A/B/C/D/F tier list, `tiers={{S: [...], F: [...]}}` |

If you add a **new** slide component, put it in
`site/src/components/slides/` and register it in the `slideComponents` map
in `pages/talks/[slug].astro` — otherwise MDX won't resolve the tag.

Per-talk images go in `site/public/talks/<talk>/` and are referenced by
absolute path: `<Image src="/talks/<talk>/diagram.png" alt="..." />`.

## Design system — don't fork it

All visual styling is CSS custom properties in
[theme.css](site/src/styles/theme.css), encoding the rules in the
`impeccable-design-rules` skill
([.agents/skills/impeccable-design-rules/SKILL.md](.agents/skills/impeccable-design-rules/SKILL.md)).
Read that skill before doing any visual/styling work on slides.

- Reskin a deck by overriding custom properties (e.g. `--brand-h` for hue) —
  never fork `theme.css` per talk.
- Dark-on-light-projector aesthetic is a deliberate default, not a
  placeholder — don't "fix" it to light mode.
- Per-slide component styles live scoped inside each `.astro` component in
  `site/src/components/slides/`.

## Slide runtime (navigation)

`site/src/runtime/deck.js` + `deck.css` (~100 lines, no deps) drive
everything: scroll-snap paging, keyboard nav (← → / Space / Home / End),
fullscreen (`F`), the progress bar, and the URL hash (`#N`) for deep-linking
mid-deck. Slide transitions are **instant** (`scroll-behavior: auto`, no
smooth animation) — that's intentional, don't reintroduce smooth scrolling
unless explicitly asked.

## Conventions summary for agents

- One `.mdx` file per talk; never split a deck across files.
- No imports needed inside talk `.mdx` files for slide components.
- Style via `theme.css` custom properties, not per-talk overrides.
- Check `site/README.md` for the human-facing version of the authoring docs.
