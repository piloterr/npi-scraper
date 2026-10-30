<?php
// NPI Provider API – PHP example (ext-curl)
// Usage: PILOTERR_API_KEY=your-key php provider.php

$params = http_build_query([
    'query' => 'https://npiregistry.cms.hhs.gov/provider-view/1972813608',
]);

$ch = curl_init('https://api.piloterr.com/v2/npi/provider?' . $params);
curl_setopt_array($ch, [
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_TIMEOUT => 60,
    CURLOPT_HTTPHEADER => ['x-api-key: ' . getenv('PILOTERR_API_KEY')],
]);

$body = curl_exec($ch);
$status = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

if ($status !== 200) {
    fwrite(STDERR, "Piloterr error $status: $body\n");
    exit(1);
}

$data = json_decode($body, true);
echo json_encode($data, JSON_PRETTY_PRINT | JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE), PHP_EOL;
