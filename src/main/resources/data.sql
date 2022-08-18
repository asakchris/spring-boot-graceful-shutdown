DELETE FROM m_user;

INSERT INTO m_user (user_id, user_name, created_at, modified_at)
  VALUES
    (nextval('user_id_seq'), 'foo_bar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (nextval('user_id_seq'), 'fizz_buzz', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
