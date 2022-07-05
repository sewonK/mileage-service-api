insert into users (user_id)
values ('3ede0ef2-92b7-4817-a5f3-0c575361f745');

insert into review (review_id, content, user_id, place_id)
values ('240a0658-dc5f-4878-9381-ebb7b2667772',
      '좋아요!',
      '3ede0ef2-92b7-4817-a5f3-0c575361f745',
      '2e4baf1c-5acb-4efb-a1af-eddada31b00f');

insert into photo
values ('afb0cef2-851d-4a50-bb07-9cc15cbdc332', '240a0658-dc5f-4878-9381-ebb7b2667772');

insert into photo
values ('e4d1a64e-a531-46de-88d0-ff0ed70c0bb8', '240a0658-dc5f-4878-9381-ebb7b2667772');
