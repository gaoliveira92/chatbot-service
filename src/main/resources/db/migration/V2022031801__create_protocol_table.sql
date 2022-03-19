create table protocol(
    id serial PRIMARY KEY,
    protocol VARCHAR ( 50 ) UNIQUE NOT NULL,
    start_date_time TIMESTAMP NOT NULL
)