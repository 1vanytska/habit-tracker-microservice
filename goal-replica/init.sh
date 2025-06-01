#!/bin/bash
set -e

export PGPASSWORD=password
rm -rf /var/lib/postgresql/data/*

pg_basebackup -h goal-master -D /var/lib/postgresql/data -U admin_user -W -P -R

cp /etc/postgresql/postgresql.conf /var/lib/postgresql/data/postgresql.conf
cp /etc/postgresql/pg_hba.conf /var/lib/postgresql/data/pg_hba.conf
