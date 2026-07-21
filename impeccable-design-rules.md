# Impeccable Design Rules

A set of rules agents should follow when creating web pages. Extracted from the `impeccable` frontend design skill (v3.9.1). Self-contained — no external references.

**Goal:** Design and iterate production-grade frontend interfaces — real working code, committed design choices, exceptional craft. Covers websites, landing pages, dashboards, product UI, app shells, components, forms, settings, onboarding, and empty states.

---

## Core philosophy

- Produce **ready-to-ship, production-grade code**, not prototypes or starting points.
- Take no shortcuts unless the user asks for them (when in doubt, ask).
- Don't stop until you arrive at a complete implementation: beautiful, responsive, fast, precise, bug-free, on brand.
- Take attention to detail seriously: battle-test every page, section, or component using available tools (browser screenshotting, computer use, etc.).
- Don't hold back — aim for extraordinary work.

## Before you start

- **Learn the existing design system.** Read the existing conventions, tokens, theme, and components in the code (at least one CSS/theme file and a representative component or page). Don't reinvent the wheel; use what's there when it works, branch out when the UX wins.
- **Pick the register.** Skipping this produces generic output.
  - **Brand register** (design IS the product): marketing, landing pages, campaigns, long-form content, portfolios.
  - **Product register** (design SERVES the product): app UI, admin, dashboards, tools.
- **Apply platform conventions.** iOS → HIG; Android → Material 3; adaptive → both; web → nothing extra.

---

## General rules (apply to all projects)

### Color

- **Verify contrast.** Body text must hit **≥4.5:1** against its background; large text (≥18px, or bold ≥14px) needs **≥3:1**. Placeholder text needs the same **4.5:1**, not a muted-gray default.
- The most common failure is muted gray body text on a tinted near-white. If contrast is even close, bump the body color toward the ink end of the ramp. Light gray "for elegance" is the single biggest reason AI designs feel hard to read.
- Gray text on a colored background looks washed out. Instead use a darker shade of the background's own hue, or a transparency of the text color.

### Typography

- Cap body line length at **65–75ch**.
- Don't pair fonts that are similar but not identical (two geometric sans-serifs, two humanist sans-serifs). Pair on a contrast axis (serif + sans, geometric + humanist), or use one family in multiple weights.
- Hero / display heading size ceiling: `clamp()` max **≤ 6rem (~96px)**. Above that the page is shouting, not designing.
- Display heading letter-spacing floor: **≥ -0.04em**. Anything tighter and letters touch — cramped, not "designed". (-0.02 to -0.03em is plenty for tight grotesque display; -0.04em is the floor.)
- Use `text-wrap: balance` on h1–h3 for even line lengths; use `text-wrap: pretty` on long prose to reduce orphans.

### Layout

- Vary spacing for rhythm.
- Cards are the lazy answer. Use them only when they're truly the best affordance. **Nested cards are always wrong.**
- Flexbox for 1D, Grid for 2D. Don't default to Grid when `flex-wrap` would be simpler.
- For responsive grids without breakpoints: `repeat(auto-fit, minmax(280px, 1fr))`.
- Build a semantic z-index scale (dropdown → sticky → modal-backdrop → modal → toast → tooltip). Never use arbitrary values like 999 or 9999.

### Motion

- Motion should be intentional, not an afterthought — consider it part of the build.
- Don't animate CSS layout properties unless truly needed.
- Ease out with exponential curves (ease-out-quart / quint / expo). No bounce, no elastic.
- Use libraries for advanced motion needs (e.g. Motion, GSAP, anime.js, Lenis).
- **Reduced motion is not optional.** Every animation needs a `@media (prefers-reduced-motion: reduce)` alternative — typically a crossfade or instant transition.
- Staggering items within one list is legitimate. The tell is the **uniform reflex** (one identical entrance applied to every section), not motion itself; each reveal should fit what it reveals. Suppressing the reflex is never a reason to ship a page with no motion at all.
- **Reveal animations must enhance an already-visible default.** Don't gate content visibility on a class-triggered transition — transitions pause on hidden tabs and headless renderers, so the reveal never fires and the section ships blank.
- Premium motion materials are not just transform/opacity. Blur, backdrop-filter, clip-path, mask, and shadow/glow are part of the palette when they materially improve the effect and stay smooth.

### Interaction

- Dropdowns rendered with `position: absolute` inside an `overflow: hidden` or `overflow: auto` container will be clipped. Use the native `<dialog>` / popover API, `position: fixed`, or a portal to escape the stacking context.

---

## New projects only (when no prior work exists)

### Color & Theme

- Use **OKLCH**.
- **The cream / sand / beige body background is the saturated AI default of 2026.** The whole warm-neutral band (OKLCH L 0.84–0.97, C < 0.06, hue 40–100) reads as cream/sand/paper/parchment regardless of what you call it. Token names like `--paper`, `--cream`, `--sand`, `--bone`, `--flour`, `--linen`, `--parchment`, `--wheat`, `--biscuit`, `--ivory` are tells in themselves. If the brief is "warm, traditional, family-coastal-Italian", "magazine-warm", or "editorial-restraint", do **not** translate that into a near-white warm-tinted bg. Instead pick:
  - (a) a saturated brand color as the body (terracotta, oxblood, deep ochre, near-black),
  - (b) a true off-white at chroma 0 (or chroma toward the brand's own hue, not toward warmth-by-default), or
  - (c) a darker mid-tone tinted neutral that's clearly the brand's own.
  - "Warmth" in the brand is carried by accent + typography + imagery, not by body bg.
- Tinted neutrals: add **0.005–0.015 chroma toward the brand's hue**. Don't default-tint toward warm or cool "because the brand feels that way" — that's the cross-project monoculture move.
- **Dark vs. light is never a default.** Not dark "because tools look cool dark". Not light "to be safe". Before choosing, write one sentence of physical scene: who uses this, where, under what ambient light, in what mood. If the sentence doesn't force the answer, it's not concrete enough — add detail until it does.
- **Pick a color strategy before picking colors.** Four steps on the commitment axis:
  - **Restrained:** tinted neutrals + one accent ≤10%. Product default; brand minimalism.
  - **Committed:** one saturated color carries 30–60% of the surface. Brand default for identity-driven pages.
  - **Full palette:** 3–4 named roles, each used deliberately. Brand campaigns; product data viz.
  - **Drenched:** the surface IS the color. Brand heroes, campaign pages.

---

## Absolute bans (match-and-refuse)

If you're about to write any of these, rewrite the element with different structure.

- **Side-stripe borders.** `border-left` / `border-right` greater than 1px as a colored accent on cards, list items, callouts, or alerts. Never intentional. Rewrite with full borders, background tints, leading numbers/icons, or nothing.
- **Gradient text.** `background-clip: text` combined with a gradient background. Decorative, never meaningful. Use a single solid color; emphasis via weight or size.
- **Glassmorphism as default.** Blurs and glass cards used decoratively. Use rarely and purposefully, or not at all.
- **The hero-metric template.** Big number, small label, supporting stats, gradient accent. SaaS cliché.
- **Identical card grids.** Same-sized cards with icon + heading + text, repeated endlessly.
- **Tiny uppercase tracked eyebrow above every section.** The 2023-era kicker (small all-caps text with wide tracking, "ABOUT" / "PROCESS" / "PRICING" above each heading) is now saturated AI scaffolding — it appears on 55–95% of generations regardless of brief. One named kicker as a deliberate brand system is voice; an eyebrow on every section is AI grammar. Choose a different cadence.
- **Numbered section markers as default scaffolding (01 / 02 / 03).** Putting `01 · About / 02 · Process / 03 · Pricing` above every section is the eyebrow trope one tier deeper. Numbers earn their place only when the section actually IS a sequence (a real 3-step process, an ordered flow, a typed timeline) and the order carries information the reader needs. One deliberate numbered sequence on one page is voice; numbered eyebrows on every section is AI grammar.
- **Text that overflows its container.** Long heading words + large clamp scales + narrow grids cause headline overflow on tablet/mobile. Test heading copy at every breakpoint; if it overflows, reduce the clamp max or rewrite the copy. The viewport is part of the design.

### Additional defects (refuse-and-rewrite)

- **`border: 1px solid X` + `box-shadow: 0 Npx Mpx …` with blur M ≥ 16px on the same element.** The "ghost-card" pattern (1px border plus soft wide drop shadow on buttons and cards). Don't pair them. Pick one: a single solid border at the brand color, OR a defined shadow at no more than 8px blur — never both as decoration.
- **`border-radius: 32px+` on cards / sections / inputs.** Over-rounding. Cards top out at **12–16px**; full-pill is fine for tags/buttons. Picking 24/28/32/40px on a card is a tell — no brand wants "insanely rounded".
- **Hand-drawn / sketchy SVG illustrations.** Class names like `loose-sketch`, `*-sketch`, `doodle`, `wavy`; `feTurbulence` / `feDisplacementMap` "paper grain" filters; 5-to-30-path crude scenes depicting a tangible subject (an otter, a table-and-fork, an album cover). These read as amateurish, not whimsical. If you can't render the scene with real assets, ship no illustration. Don't attempt sketchy SVG as a fallback.
- **`repeating-linear-gradient(…)` stripe backgrounds.** Diagonal stripes in `body:before` or section backgrounds are pure decoration. Don't.
- **Decorative grid backgrounds.** Two-axis CSS grid overlays built from `linear-gradient(… 1px, transparent 1px)` plus `background-size`, unless the surface is an actual canvas, map, blueprint, or measurement tool. Use product structure, real artifacts, or a plain surface instead.
- **Meta-criticism copy.** Naming a concept then layering an ironic modifier, or staging a strawman to "correct" it. Make the specific claim instead.

---

## The AI slop test

If someone could look at this interface and say "AI made that" without doubt, it has failed.

**Category-reflex check — run at two altitudes:**

- **First-order:** if someone could guess the theme + palette from the category alone, it's the first training-data reflex. Rework the scene sentence and color strategy until the answer isn't obvious from the domain.
- **Second-order:** if someone could guess the aesthetic family from category-plus-anti-references ("AI workflow tool that's not SaaS-cream → editorial-typographic"; "fintech that's not navy-and-gold → terminal-native dark mode"), it's the trap one tier deeper. The first reflex was avoided; the second wasn't. Rework until **both** answers are non-obvious.
