#!/usr/bin/env bash
# NPI Provider API – cURL example
# Usage: PILOTERR_API_KEY=your-key ./provider.sh
set -euo pipefail

curl -sS -G "https://api.piloterr.com/v2/npi/provider" \
  -H "x-api-key: ${PILOTERR_API_KEY}" \
  --data-urlencode query=https://npiregistry.cms.hhs.gov/provider-view/1972813608
