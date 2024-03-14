#!/usr/bin/env bash

awk '{match($0,/[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+/); ip=substr($0,RSTART,RLENGTH); if (!seen[ip]++) print $0}' text-deduplication-by-ip.txt > text-deduplication-by-ip-deduped.txt
