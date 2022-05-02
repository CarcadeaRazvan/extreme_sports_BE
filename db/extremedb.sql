--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2 (Debian 14.2-1.pgdg110+1)
-- Dumped by pg_dump version 14.2 (Debian 14.2-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: counties; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.counties (
    countyid bigint NOT NULL,
    countryid bigint,
    name character varying(255),
    country bigint
);


ALTER TABLE public.counties OWNER TO admin;

--
-- Name: countries; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.countries (
    countryid bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.countries OWNER TO admin;

--
-- Name: countryseq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.countryseq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.countryseq OWNER TO admin;

--
-- Name: countyseq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.countyseq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.countyseq OWNER TO admin;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO admin;

--
-- Name: locations; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.locations (
    locationid bigint NOT NULL,
    countyid bigint,
    name character varying(255),
    county bigint
);


ALTER TABLE public.locations OWNER TO admin;

--
-- Name: locationseq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.locationseq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.locationseq OWNER TO admin;

--
-- Name: sports; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.sports (
    sportid bigint NOT NULL,
    avgcostperday double precision,
    endingdate date,
    locationid bigint,
    name character varying(255),
    startingdate date,
    location bigint
);


ALTER TABLE public.sports OWNER TO admin;

--
-- Name: sportseq; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.sportseq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sportseq OWNER TO admin;

--
-- Data for Name: counties; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.counties (countyid, countryid, name, country) FROM stdin;
\.


--
-- Data for Name: countries; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.countries (countryid, name) FROM stdin;
\.


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.locations (locationid, countyid, name, county) FROM stdin;
\.


--
-- Data for Name: sports; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.sports (sportid, avgcostperday, endingdate, locationid, name, startingdate, location) FROM stdin;
\.


--
-- Name: countryseq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.countryseq', 1, false);


--
-- Name: countyseq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.countyseq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- Name: locationseq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.locationseq', 1, false);


--
-- Name: sportseq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.sportseq', 1, false);


--
-- Name: counties counties_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.counties
    ADD CONSTRAINT counties_pkey PRIMARY KEY (countyid);


--
-- Name: countries countries_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (countryid);


--
-- Name: locations locations_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (locationid);


--
-- Name: sports sports_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.sports
    ADD CONSTRAINT sports_pkey PRIMARY KEY (sportid);


--
-- Name: counties fk6bdh369bc3a470e8ximrdx3l5; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.counties
    ADD CONSTRAINT fk6bdh369bc3a470e8ximrdx3l5 FOREIGN KEY (country) REFERENCES public.countries(countryid);


--
-- Name: sports fkewovs2mvnucu8om1y5r6n9clc; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.sports
    ADD CONSTRAINT fkewovs2mvnucu8om1y5r6n9clc FOREIGN KEY (location) REFERENCES public.locations(locationid);


--
-- Name: locations fkni0v8hl6jm7hx7kwrojja0lny; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.locations
    ADD CONSTRAINT fkni0v8hl6jm7hx7kwrojja0lny FOREIGN KEY (county) REFERENCES public.counties(countyid);


--
-- PostgreSQL database dump complete
--

