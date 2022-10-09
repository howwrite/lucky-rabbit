create table if not exists `user`
(
    `id`              bigint unsigned not null auto_increment primary key comment 'id',
    `nickname`        varchar(32)     not null comment '昵称',
    `avatarUrl`       varchar(512)             default null comment '头像地址',
    `password`        varchar(256)             default null comment '密码',
    `prefix`          varchar(8)      not null comment '手机国际区号',
    `mobile`          varchar(32)     not null comment '手机号码',
    `last_login_time` datetime                 default null comment '最后登录时间',
    `deleted`         bigint unsigned not null default 0 comment '逻辑删除',
    `deleted_time`    bigint                   default null comment '删除时间',
    `created_time`    datetime        not null default now() comment '创建时间',
    `updated_time`    datetime        not null on update current_timestamp comment '记录修改时间',
    unique key `uni_mobile` (`prefix`, `mobile`, `deleted`),
    unique key `uni_nickname` (`nickname`, `deleted`)
) default charset = utf8mb4 comment = '用户主表';

create table if not exists avatar_template
(
    `id`           bigint unsigned                      not null auto_increment primary key comment 'id',
    `created_time` datetime                             not null default now() comment '创建时间',
    `updated_time` datetime on update current_timestamp not null comment '记录修改时间',
    `name`         varchar(32)                          not null comment '头像模板名称',
    `type`         varchar(32)                          not null comment '头像模板类型',
    `body`         text                                 not null comment '头像模板内容',
    unique key `uni_name` (`name`)
) default charset = utf8mb4 comment '头像模板';