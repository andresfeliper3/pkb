-- Insert mock users into the Users table
INSERT INTO users (user_id, username, email, password_hash, created_at) VALUES
(1, 'john_doe', 'john@example.com', 'hashedpassword123', '2023-01-01 10:00:00'),
(2, 'jane_doe', 'jane@example.com', 'hashedpassword456', '2023-01-02 11:00:00');

-- Insert mock snippets into the Snippets table
INSERT INTO snippets (snippet_id, user_id, title, content, created_at, updated_at) VALUES
(1, 1, 'Snippet 1 Title', 'This is the content of snippet 1.', '2023-01-01 10:00:00', '2023-01-01 10:05:00'),
(2, 1, 'Snippet 2 Title', 'This is the content of snippet 2.', '2023-01-01 11:00:00', '2023-01-01 11:15:00'),
(3, 2, 'Snippet 3 Title', 'This is the content of snippet 3.', '2023-01-02 12:00:00', NULL);