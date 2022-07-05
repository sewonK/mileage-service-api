SET foreign_key_checks = 0;
DROP TABLE IF EXISTS users;
CREATE TABLE users(
    user_id varchar(36) unique not null,
    point int DEFAULT 0,
    primary key (user_id)
);

DROP TABLE IF EXISTS review;
CREATE TABLE review(
    review_id varchar(36) unique not null,
    content varchar(2000),
    user_id varchar(36),
    place_id varchar(36),
    created_date timestamp not null default current_timestamp,
    updated_date timestamp not null default current_timestamp on update current_timestamp,
    primary key (review_id),
    foreign key fk_user (user_id) references users(user_id),
    key idx_place(place_id, created_date)
);

DROP TABLE IF EXISTS photo;
CREATE TABLE photo(
    photo_id varchar(36) unique not null,
    review_id varchar(36),
    primary key (photo_id),
    foreign key fk_review (review_id) references review(review_id)
);

DROP TABLE IF EXISTS point_history;
CREATE TABLE point_history(
    history_id varchar(36) unique not null,
    review_id varchar(36),
    user_id varchar(36),
    point_type varchar(10),
    point_details varchar(10),
    point int,
    created_date timestamp not null default current_timestamp,
    primary key (history_id),
    foreign key fk_review (review_id) references review(review_id),
    foreign key fk_user (user_id) references users(user_id),
    key idx_review (review_id, point_details),
    key idx_user (user_id)
);
SET foreign_key_checks = 1;
