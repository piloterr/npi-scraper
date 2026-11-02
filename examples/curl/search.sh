#!/usr/bin/env bash
# NPI Search API – cURL example
# Usage: PILOTERR_API_KEY=your-key ./search.sh
set -euo pipefail

curl -sS --fail-with-body -G "https://api.piloterr.com/v2/npi/search" \
  -H "x-api-key: ${PILOTERR_API_KEY}" \
  --data-urlencode 'query=Anthony Fauci. Also a 10-digit NPI such as 1972813608, or an NPPES search URL. With enumeration_type=NPI-2 this text is the organization name, for example Mayo Clinic. A provider-view URL is rejected here.'
