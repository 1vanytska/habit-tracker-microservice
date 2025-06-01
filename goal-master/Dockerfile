FROM postgres:16
COPY ./postgresql.conf /etc/postgresql/postgresql.conf
COPY ./pg_hba.conf /etc/postgresql/pg_hba.conf
COPY ./init.sh /docker-entrypoint-initdb.d/
