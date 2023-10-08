
    create table address (
        deleted bit,
        postal_code integer,
        costumer_id bigint,
        id bigint not null auto_increment,
        address varchar(255),
        city varchar(255),
        nation varchar(255),
        province varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table contract (
        deleted bit,
        customer_id bigint,
        id bigint not null auto_increment,
        contact_type varchar(255),
        value varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table course (
        deleted bit,
        price float(53),
        id bigint not null auto_increment,
        denomination varchar(255),
        difficulty varchar(255),
        sport varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table custumer (
        deleted bit,
        birth_name datetime(6),
        customer_id bigint,
        id bigint not null auto_increment,
        name varchar(255),
        surname varchar(255),
        tax_code varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table address 
       add constraint UK_3vgm487camv8qookup1x5li0j unique (costumer_id);

    alter table custumer 
       add constraint UK_elygadrmo6ehgruhdngnga0e5 unique (customer_id);

    alter table address 
       add constraint FKic0yytbnam1u72poa8j1apjo5 
       foreign key (costumer_id) 
       references custumer (id);

    alter table contract 
       add constraint FKsy4dsg2roek0m04tx5xx6k6h3 
       foreign key (customer_id) 
       references custumer (id);

    alter table custumer 
       add constraint FK2o0an8wnkn0xnag8xg87rcc42 
       foreign key (customer_id) 
       references address (id);

    create table address (
        deleted bit,
        postal_code integer,
        costumer_id bigint,
        id bigint not null auto_increment,
        address varchar(255),
        city varchar(255),
        nation varchar(255),
        province varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table contract (
        deleted bit,
        customer_id bigint,
        id bigint not null auto_increment,
        contact_type varchar(255),
        value varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table course (
        deleted bit,
        price float(53),
        id bigint not null auto_increment,
        denomination varchar(255),
        difficulty varchar(255),
        sport varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table custumer (
        deleted bit,
        birth_name datetime(6),
        customer_id bigint,
        id bigint not null auto_increment,
        name varchar(255),
        surname varchar(255),
        tax_code varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table address 
       add constraint UK_3vgm487camv8qookup1x5li0j unique (costumer_id);

    alter table custumer 
       add constraint UK_elygadrmo6ehgruhdngnga0e5 unique (customer_id);

    alter table address 
       add constraint FKic0yytbnam1u72poa8j1apjo5 
       foreign key (costumer_id) 
       references custumer (id);

    alter table contract 
       add constraint FKsy4dsg2roek0m04tx5xx6k6h3 
       foreign key (customer_id) 
       references custumer (id);

    alter table custumer 
       add constraint FK2o0an8wnkn0xnag8xg87rcc42 
       foreign key (customer_id) 
       references address (id);

    create table address (
        deleted bit,
        postal_code integer,
        costumer_id bigint,
        id bigint not null auto_increment,
        address varchar(255),
        city varchar(255),
        nation varchar(255),
        province varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table contract (
        deleted bit,
        customer_id bigint,
        id bigint not null auto_increment,
        contact_type varchar(255),
        value varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table course (
        deleted bit,
        price float(53),
        id bigint not null auto_increment,
        denomination varchar(255),
        difficulty varchar(255),
        sport varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table custumer (
        deleted bit,
        birth_name datetime(6),
        customer_id bigint,
        id bigint not null auto_increment,
        name varchar(255),
        surname varchar(255),
        tax_code varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table address 
       add constraint UK_3vgm487camv8qookup1x5li0j unique (costumer_id);

    alter table custumer 
       add constraint UK_elygadrmo6ehgruhdngnga0e5 unique (customer_id);

    alter table address 
       add constraint FKic0yytbnam1u72poa8j1apjo5 
       foreign key (costumer_id) 
       references custumer (id);

    alter table contract 
       add constraint FKsy4dsg2roek0m04tx5xx6k6h3 
       foreign key (customer_id) 
       references custumer (id);

    alter table custumer 
       add constraint FK2o0an8wnkn0xnag8xg87rcc42 
       foreign key (customer_id) 
       references address (id);
