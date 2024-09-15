INSERT INTO author (name, surname, middle_name, birthday_date)
VALUES
    ('Donald', 'Knuth', 'Ervin', '1938-01-10'),
    ('Brian', 'Kernighan', 'Wilson', '1942-01-01'),
    ('Andrew', 'Tanenbaum', 'Stuart', '1944-08-16'),
    ('Robert', 'Martin', 'Carl', '1952-06-05'),
    ('Joshua', 'Bloch', NULL, '1961-07-28'),
    ('Leo', 'Tolstoy', 'Nikolaevich', '1828-09-09'),
    ('Jane', 'Austen', NULL, '1775-12-16'),
    ('Fyodor', 'Dostoevsky', 'Mikhailovich', '1821-11-11'),
    ('Virginia', 'Woolf', NULL, '1882-01-25'),
    ('Gabriel', 'Garcia Marquez', NULL, '1927-03-06');

INSERT INTO book(name, page_count, genre, author_id)
VALUES
-- Книги Дональда Кнута
('The Art of Computer Programming, Vol. 1', 672, 'COMPUTER_SCIENCE', 1),
('The Art of Computer Programming, Vol. 2', 736, 'COMPUTER_SCIENCE', 1),

-- Книги Брайана Кернигана
('The C Programming Language', 288, 'PROGRAMMING', 2),
('Unix: A History and a Memoir', 272, 'COMPUTER_SCIENCE', 2),

-- Книги Эндрю Таненбаума
('Operating Systems: Design and Implementation', 1040, 'COMPUTER_SCIENCE', 3),
('Structured Computer Organization', 832, 'COMPUTER_SCIENCE', 3),

-- Книги Роберта Мартина
('Clean Code: A Handbook of Agile Software Craftsmanship', 464, 'SOFTWARE_ENGINEERING', 4),
('Agile Principles, Patterns, and Practices in C#', 624, 'SOFTWARE_ENGINEERING', 4),

-- Книги Джошуа Блоха
('Effective Java', 416, 'PROGRAMMING', 5),
('Java Concurrency in Practice', 512, 'PROGRAMMING', 5),

-- Книги Льва Толстого
('Война и мир', 1216, 'HISTORICAL_FICTION', 6),
('Анна Каренина', 864, 'HISTORICAL_FICTION', 6),

-- Книги Джейн Остин
('Гордость и предубеждение', 416, 'ROMANCE', 7),
('Чувство и чувствительность', 384, 'ROMANCE', 7),

-- Книги Фёдора Достоевского
('Преступление и наказание', 560, 'PSYCHOLOGICAL_FICTION', 8),
('Братья Карамазовы', 832, 'PSYCHOLOGICAL_FICTION', 8),

-- Книги Вирджинии Вулф
('Миссис Дэллоуэй', 224, 'MODERNIST_LITERATURE', 9),
('На мельнице', 192, 'MODERNIST_LITERATURE', 9),

-- Книги Габриэля Гарсиа Маркеса
('Сто лет одиночества', 448, 'MAGICAL_REALISM', 10),
('Любовь во время чумы', 368, 'MAGICAL_REALISM', 10);