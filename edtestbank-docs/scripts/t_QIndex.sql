-- auto-generated definition
create table QIndex
(
    id        bigint auto_increment
        primary key,
    questions longtext collate utf8mb4_bin default '' not null,
    dateC     datetime                                not null,
    dateM     datetime                                not null,
    uuid      varchar(64)                             not null
);

