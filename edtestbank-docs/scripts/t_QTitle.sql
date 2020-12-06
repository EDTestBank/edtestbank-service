-- auto-generated definition
create table QTitle
(
    id             bigint auto_increment
        primary key,
    qIndex_id      bigint             not null,
    questionNumber smallint default 0 not null,
    questionTitle  varchar(1024)      null,
    questionA      varchar(1024)      null,
    questionB      varchar(1024)      null,
    questionC      varchar(1024)      null,
    questionD      varchar(1024)      null,
    questionE      varchar(1024)      null,
    questionF      varchar(1024)      null,
    dateC          datetime           null,
    dateM          datetime           null,
    uuid           varchar(64)        null,
    constraint FK_QTitle_QIndex
        foreign key (qIndex_id) references QIndex (id)
);

