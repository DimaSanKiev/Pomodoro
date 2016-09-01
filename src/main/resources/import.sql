INSERT INTO role (name) VALUES ('ROLE_USER');

INSERT INTO quest (name) VALUES ('New test quest.');

-- Insert users (password is 'password')
INSERT INTO user (first_name, last_name, sound_alert, username, password, enabled, role_id)
  VALUES ('FirstName', 'LastName', TRUE, 'user', '$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u', TRUE, 1);

INSERT INTO user_quests (user_id, quests_id) VALUES (1, 1);

