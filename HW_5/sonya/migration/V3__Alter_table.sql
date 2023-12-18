ALTER TABLE publishing_house
    ALTER COLUMN name SET NOT NULL,
    ALTER COLUMN city SET NOT NULL;

ALTER TABLE library
    ALTER COLUMN name SET NOT NULL,
    ALTER COLUMN adress SET NOT NULL,

ALTER TABLE book
    ALTER COLUMN name SET NOT NULL,
    ALTER COLUMN author SET NOT NULL,
    ALTER COLUMN take SET NOT NULL,
    ADD CONSTRAINT fk_publisher_id
        FOREIGN KEY (publisher_id)
        REFERENCES publishing_house(id);




