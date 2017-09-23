--CREATE TABLE Users (
--  "id"    SERIAL PRIMARY KEY,
--  "fio"
--  "role"  VARCHAR(30) NOT NULL,
--  "login" VARCHAR(50) NOT NULL,
--  "email" VARCHAR(50) NOT NULL
--);

CREATE TABLE credentials (
  "id"    SERIAL PRIMARY KEY,
  "role"  VARCHAR(30) NOT NULL,
  "login" VARCHAR(50) NOT NULL,
  "email" VARCHAR(50) NOT NULL
);

CREATE TABLE images.hotels (
  "id"      SERIAL PRIMARY KEY,
  "name"    VARCHAR(50)  NOT NULL,
  "photo"   VARCHAR(100) NOT NULL,
  "city"    VARCHAR(50)  NOT NULL,
  "address" VARCHAR(50)  NOT NULL,
  "stars"   INTEGER      NOT NULL
);
CREATE TABLE guests (
  "id"            SERIAL PRIMARY KEY,
  "credential_id" INTEGER REFERENCES credentials ("id"),
  "fio"           VARCHAR(50) NOT NULL,
  "phone_number"  VARCHAR(50)
);

CREATE TABLE hotel_admins (
  "id"            SERIAL PRIMARY KEY,
  "hotel_id"      INTEGER REFERENCES images.hotels ("id"),
  "credential_id" INTEGER REFERENCES credentials ("id"),
  "fio"           VARCHAR(50) NOT NULL,
  "hire_date"     DATE,
  "birthday"      DATE
);

CREATE TABLE bookings (
  "id"        SERIAL PRIMARY KEY,
  "room_id"   INTEGER REFERENCES rooms ("id"),
  "check_in"  DATE,
  "check_out" DATE
);

CREATE TABLE rooms (
  "id"       SERIAL PRIMARY KEY,
  "hotel_id" INTEGER REFERENCES images.hotels ("id"),
  "number"   INTEGER      NOT NULL,
  "price"    FLOAT        NOT NULL,
  "photo"    VARCHAR(100) NOT NULL
);

ALTER TABLE credentials
    add "password" VARCHAR(50) NOT NULL
































CREATE TABLE Class (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR(30) NOT NULL,
	"description" VARCHAR(2000),
	"photo" VARCHAR(100)
);

CREATE TABLE Instructor(
	"id" SERIAL PRIMARY KEY,
	"users_id" INTEGER NOT NULL REFERENCES Users("id"),
	"description" VARCHAR(1000),
	"qualification" VARCHAR(400),
	"awards" VARCHAR(400),
	"experience" DATE
);

CREATE TABLE Schedule(
	"id" SERIAL PRIMARY KEY,
	"class_id" INTEGER REFERENCES Class("id"),
	"instr_id" INTEGER REFERENCES Instructor("id"),
	"startTime" INTEGER NOT NULL CONSTRAINT CH_start_time CHECK ("startTime" IN (9, 10, 11,
		12, 13, 14, 15, 16, 17, 18, 19, 20)),
	"dayOfWeek" VARCHAR(10) NOT NULL CONSTRAINT CH_day_of_week CHECK("dayOfWeek" IN ('MONDAY',
		'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'))
);

CREATE TABLE ProbablyInstructor (
	"id" SERIAL PRIMARY KEY,
	"users_id" INTEGER NOT NULL REFERENCES Users("id")
);

CREATE TABLE Subscription (
	"id" SERIAL PRIMARY KEY,
	"validity" INTEGER NOT NULL CONSTRAINT CH_validity CHECK ("validity" IN (1, 2, 3, 6, 12, 15)),
	"price" INTEGER
);

CREATE TABLE Purchase (
	"id" SERIAL PRIMARY KEY,
	"users_id" INTEGER NOT NULL REFERENCES Users("id"),
	"subscr_id" INTEGER NOT NULL REFERENCES Subscription("id"),
	"buy_date" DATE NOT NULL,
	"prolong" INTEGER CONSTRAINT CH_prolong CHECK ("prolong" IN (0, 1))
);



