/*
 * deck.js — the whole slide runtime. Navigation + fullscreen + progress, no deps.
 * Slides are `.slide` sections inside `.deck`; scroll-snap handles the visuals.
 */
function initDeck() {
  const deck = document.querySelector('.deck');
  if (!deck) return;

  const slides = Array.from(deck.querySelectorAll('.slide'));
  if (slides.length === 0) return;

  const progress = document.querySelector('.deck-progress');
  const counter = document.querySelector('.deck-counter');
  let current = 0;

  const clamp = (i) => Math.max(0, Math.min(slides.length - 1, i));

  function render() {
    if (progress) progress.style.transform = `scaleX(${(current + 1) / slides.length})`;
    if (counter) counter.textContent = `${current + 1} / ${slides.length}`;
    const hash = `#${current + 1}`;
    if (location.hash !== hash) history.replaceState(null, '', hash);
  }

  function goto(index) {
    current = clamp(index);
    slides[current].scrollIntoView({ behavior: 'auto' });
    render();
  }

  const next = () => goto(current + 1);
  const prev = () => goto(current - 1);

  // Keep `current` in sync when the user scrolls / swipes manually.
  const observer = new IntersectionObserver(
    (entries) => {
      for (const entry of entries) {
        if (entry.isIntersecting) {
          current = slides.indexOf(entry.target);
          render();
        }
      }
    },
    { root: deck, threshold: 0.6 }
  );
  slides.forEach((s) => observer.observe(s));

  document.addEventListener('keydown', (e) => {
    if (e.metaKey || e.ctrlKey || e.altKey) return;
    switch (e.key) {
      case 'ArrowRight':
      case 'ArrowDown':
      case 'PageDown':
      case ' ':
        e.preventDefault();
        next();
        break;
      case 'ArrowLeft':
      case 'ArrowUp':
      case 'PageUp':
        e.preventDefault();
        prev();
        break;
      case 'Home':
        e.preventDefault();
        goto(0);
        break;
      case 'End':
        e.preventDefault();
        goto(slides.length - 1);
        break;
      case 'f':
      case 'F':
        e.preventDefault();
        if (document.fullscreenElement) document.exitFullscreen();
        else deck.requestFullscreen?.();
        break;
    }
  });

  // Click / tap the slide (but not a link/button) advances.
  deck.addEventListener('click', (e) => {
    if (e.target.closest('a, button')) return;
    next();
  });

  // Deep link: open on #N.
  const start = parseInt(location.hash.slice(1), 10);
  if (Number.isFinite(start) && start >= 1) goto(start - 1);
  else render();
}

if (document.readyState !== 'loading') initDeck();
else document.addEventListener('DOMContentLoaded', initDeck);
