-- salesman definition

CREATE TABLE salesman (
    registration UUID NOT NULL,
    name VARCHAR(50),
    CONSTRAINT salesman_pk PRIMARY KEY (registration)
);

-- product definition
-- Drop table
-- DROP TABLE product;

CREATE TABLE product (
    id UUID NOT NULL,
    name VARCHAR(50),
    price NUMERIC,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- sale definition
-- Drop table
-- DROP TABLE sale;

CREATE TABLE sale (
    id UUID NOT NULL,
    salesman_registration UUID NOT NULL,
    amount NUMERIC,
    CONSTRAINT sale_pk PRIMARY KEY (id),
    CONSTRAINT sale_fk_salesman
        FOREIGN KEY (salesman_registration)
            REFERENCES salesman(registration)
);

-- product_sale definition
-- Drop table
-- DROP TABLE product_sale;

CREATE TABLE product_sale (
    id INT GENERATED ALWAYS AS IDENTITY,
    product_id UUID NOT NULL,
    sale_id UUID NOT NULL,
    CONSTRAINT product_sale_pk PRIMARY KEY (id),
    CONSTRAINT product_sale_fk_product
        FOREIGN KEY (product_id)
            REFERENCES product(id),
    CONSTRAINT product_sale_fk_sale
        FOREIGN KEY (sale_id)
            REFERENCES sale(id)
);
