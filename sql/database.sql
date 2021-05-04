create table if not exists antigen_and_antibody
(
    id               bigint auto_increment
        primary key,
    patient_name     varchar(5)  default ''                not null,
    patient_gender   varchar(5)  default ''                not null,
    patient_age      varchar(5)  default ''                not null,
    reporting_time   date                                  not null,
    sending_doctor   varchar(5)  default ''                not null,
    department       varchar(10) default ''                not null,
    collecting_time  date                                  not null,
    phone_number     varchar(15) default ''                not null,
    created_at       datetime    default CURRENT_TIMESTAMP not null,
    surface_antigen  varchar(20) default ''                not null,
    surface_antibody varchar(20) default ''                not null
);

create table if not exists blood_sugar
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    sugar           varchar(20) default ''                not null
);

create table if not exists crp
(
    id                    bigint auto_increment
        primary key,
    patient_name          varchar(5)  default ''                not null,
    patient_gender        varchar(5)  default ''                not null,
    patient_age           varchar(5)  default ''                not null,
    reporting_time        date                                  not null,
    sending_doctor        varchar(5)  default ''                not null,
    department            varchar(10) default ''                not null,
    collecting_time       date                                  not null,
    phone_number          varchar(15) default ''                not null,
    created_at            datetime    default CURRENT_TIMESTAMP not null,
    general_crp_result    varchar(20) default ''                not null,
    general_crp_reference varchar(20) default ''                not null,
    hs_crp_result         varchar(20) default ''                not null,
    hs_crp_reference      varchar(20) default ''                not null
);

create table if not exists feces
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    feces_color     varchar(20) default ''                not null,
    feces_shape     varchar(20) default ''                not null,
    feces_mucus     varchar(20) default ''                not null,
    feces_pus_ball  varchar(20) default ''                not null,
    occult_blood    varchar(20) default ''                not null
);

create table if not exists glycation
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    hemoglobin      varchar(20) default ''                not null
);

create table if not exists guc
(
    id                            bigint auto_increment
        primary key,
    patient_name                  varchar(5)  default ''                not null,
    patient_gender                varchar(5)  default ''                not null,
    patient_age                   varchar(5)  default ''                not null,
    reporting_time                date                                  not null,
    sending_doctor                varchar(5)  default ''                not null,
    department                    varchar(10) default ''                not null,
    collecting_time               date                                  not null,
    phone_number                  varchar(15) default ''                not null,
    created_at                    datetime    default CURRENT_TIMESTAMP not null,
    glutamic_pyruvic_transaminase varchar(20) default ''                not null
);

create table if not exists health_card
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    antigen         varchar(20) default ''                not null,
    antibody        varchar(20) default ''                not null,
    e_antigen       varchar(20) default ''                not null,
    e_antibody      varchar(20) default ''                not null,
    core_antibody   varchar(20) default ''                not null,
    hepatitis       varchar(20) default ''                not null
);

create table if not exists hiv
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    hiv_result      varchar(20) default ''                not null,
    rpr_result      varchar(20) default ''                not null
);

create table if not exists leukocyte_routine
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    cleanliness     varchar(20) default ''                not null,
    pus_ball        varchar(20) default ''                not null,
    mold            varchar(20) default ''                not null,
    trichomonas     varchar(20) default ''                not null,
    g_diplococcus   varchar(20) default ''                not null
);

create table if not exists pregnancy
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    result          varchar(20) default ''                not null
);

create table if not exists pregnant_women
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    blood_type      varchar(20) default ''                not null,
    rh              varchar(20) default ''                not null,
    hbsag           varchar(20) default ''                not null,
    hbsab           varchar(20) default ''                not null,
    rpr             varchar(20) default ''                not null,
    hepatitis       varchar(20) default ''                not null,
    hiv             varchar(20) default ''                not null
);

create table if not exists prostate_fluid
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    appearance      varchar(20) default ''                not null,
    lecithin        varchar(20) default ''                not null,
    leukocyte       varchar(20) default ''                not null,
    erythrocyte     varchar(20) default ''                not null,
    epithelium      varchar(20) default ''                not null
);

create table if not exists serum
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    thyrotropin     varchar(20) default ''                not null
);

create table if not exists two_and_half
(
    id              bigint auto_increment
        primary key,
    patient_name    varchar(5)  default ''                not null,
    patient_gender  varchar(5)  default ''                not null,
    patient_age     varchar(5)  default ''                not null,
    reporting_time  date                                  not null,
    sending_doctor  varchar(5)  default ''                not null,
    department      varchar(10) default ''                not null,
    collecting_time date                                  not null,
    phone_number    varchar(15) default ''                not null,
    created_at      datetime    default CURRENT_TIMESTAMP not null,
    antigen         varchar(20) default ''                not null,
    antibody        varchar(20) default ''                not null,
    e_antigen       varchar(20) default ''                not null,
    e_antibody      varchar(20) default ''                not null,
    core_antibody   varchar(20) default ''                not null
);

create table if not exists urine_routine
(
    id                     bigint auto_increment
        primary key,
    patient_name           varchar(5)  default ''                not null,
    patient_gender         varchar(5)  default ''                not null,
    patient_age            varchar(5)  default ''                not null,
    reporting_time         date                                  not null,
    sending_doctor         varchar(5)  default ''                not null,
    department             varchar(10) default ''                not null,
    collecting_time        date                                  not null,
    phone_number           varchar(15) default ''                not null,
    created_at             datetime    default CURRENT_TIMESTAMP not null,
    vitamin                varchar(20) default ''                not null,
    acidity_and_alkalinity varchar(20) default ''                not null,
    leukocytes             varchar(20) default ''                not null,
    urine_specific_gravity varchar(20) default ''                not null,
    glucose                varchar(20) default ''                not null,
    nitrite                varchar(20) default ''                not null,
    protein                varchar(20) default ''                not null,
    occult_blood           varchar(20) default ''                not null,
    ketone_body            varchar(20) default ''                not null,
    urobilinogen           varchar(20) default ''                not null,
    bilirubin              varchar(20) default ''                not null
);


