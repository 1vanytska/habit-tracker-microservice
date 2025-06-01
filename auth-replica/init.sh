#!/bin/bash
set -e

rm -rf /var/lib/postgresql/data/*

# Base backup from master
pg_basebackup -h auth-master -D /var/lib/postgresql/data -U admin_user -W -P -R

# Optional: copy config if needed
cp /etc/postgresql/postgresql.conf /var/lib/postgresql/data/postgresql.conf
cp /etc/postgresql/pg_hba.conf /var/lib/postgresql/data/pg_hba.conf
