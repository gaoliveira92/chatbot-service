create table protocol_history(
    id VARCHAR ( 50 ) UNIQUE NOT NULL,
    protocol VARCHAR ( 50 ) NOT NULL,
    data VARCHAR (255),
    date_time TIMESTAMP NOT NULL
)