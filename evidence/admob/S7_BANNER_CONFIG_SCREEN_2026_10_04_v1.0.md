# S7 Banner ad-unit configuration screen — 2026-10-04

Product: PHOTO COMPRESSOR: KB LIMIT
Scope: S7 BOUNDED ADMOB PROVIDER SETUP

## User-supplied authenticated AdMob UI evidence

The Configure ad unit settings screen shows:
- Ad format: Banner
- Ad unit name: blank
- Partner bidding: unchecked
- Ad type:
  - Text, image, and rich media: checked
  - Video: checked
- Automatic refresh:
  - Google optimized: selected
  - Custom: available
  - Disabled: available
- eCPM floor:
  - Google optimized: selected
  - Manual floor: available
  - Disabled: available
- Google-optimized method:
  - High floor (Beta)
  - Medium floor (Beta)
  - All prices: selected

## Approved configuration

- Ad unit name: `ResultScreen_Banner_v1`
- Partner bidding: OFF / unchecked
- Ad types: keep both checked
- Automatic refresh: Google optimized
- eCPM floor: Google optimized
- eCPM optimization method: All prices

Rationale:
- no third-party mediation is in scope, so partner bidding must remain off;
- keeping both ad types enabled maximizes eligible demand;
- Google optimized refresh is the provider-recommended default for banner units;
- Google optimized eCPM floor with All prices prioritizes fill rate, appropriate for the initial single-banner launch.

## Next bounded action

Create exactly this one banner ad unit and record the provider-generated ad-unit ID.

No second ad unit, mediation, additional format, Play mutation, Privacy message publication, production code binding, release, or publication is authorized by this evidence record.
