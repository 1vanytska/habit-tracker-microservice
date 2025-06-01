FROM postgres:15

COPY ./postgresql.conf /etc/postgresql/postgresql.conf
COPY ./pg_hba.conf /etc/postgresql/pg_hba.conf
COPY ./init.sh /docker-entrypoint-initdb.d/init.sh

CMD ["postgres", "-c", "config_file=/etc/postgresql/postgresql.conf"]