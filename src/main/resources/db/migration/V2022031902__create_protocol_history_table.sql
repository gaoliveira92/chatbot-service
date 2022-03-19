create table protocol_historic(
    id VARCHAR ( 50 ) UNIQUE NOT NULL,
    protocol_id VARCHAR ( 50 ) REFERENCES protocol (protocol_id),
    data VARCHAR (255),
    date_time TIMESTAMP NOT NULL
)
