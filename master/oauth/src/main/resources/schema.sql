drop table if exists oauth_client_details;
create table oauth_client_details (
 client_id VARCHAR(255) PRIMARY KEY,
 resource_ids VARCHAR(255),
 client_secret VARCHAR(500),
 scope VARCHAR(255),
 authorized_grant_types VARCHAR(255),
 web_server_redirect_uri VARCHAR(255),
 authorities VARCHAR(255),
 access_token_validity INTEGER,
 refresh_token_validity INTEGER,
 additional_information VARCHAR(4096),
 autoapprove VARCHAR(255)
);

drop table if exists oauth_client_token;
create table if not exists oauth_client_token (
 token_id VARCHAR(255),
 token LONGTEXT,
 authentication_id VARCHAR(255) PRIMARY KEY,
 user_name VARCHAR(255),
 client_id VARCHAR(255)
);

drop table if exists oauth_access_token;
create table if not exists oauth_access_token (
 token_id VARCHAR(255),
 token LONGTEXT,
 authentication_id VARCHAR(255) PRIMARY KEY,
 user_name VARCHAR(255),
 client_id VARCHAR(255),
 authentication LONG BINARY,
 refresh_token VARCHAR(255)
);

drop table if exists oauth_refresh_token;
create table if not exists oauth_refresh_token (
 token_id VARCHAR(255),
 token LONGTEXT,
 authentication LONG BINARY
);

drop table if exists oauth_code;
create table if not exists oauth_code (
 code VARCHAR(255), authentication LONG BINARY
);

drop table if exists oauth_approvals;
create table if not exists oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

drop table if exists ClientDetails;
create table if not exists ClientDetails (
 appId VARCHAR(255) PRIMARY KEY,
 resourceIds VARCHAR(255),
 appSecret VARCHAR(255),
 scope VARCHAR(255),
 grantTypes VARCHAR(255),
 redirectUrl VARCHAR(255),
 authorities VARCHAR(255),
 access_token_validity INTEGER,
 refresh_token_validity INTEGER,
 additionalInformation VARCHAR(4096),
 autoApproveScopes VARCHAR(255)
);

drop table if exists users;
create table if not exists Users (
    id bigint primary key auto_increment,
    username varchar(255),
    password varchar(255),
    authorities varchar(255),
    accountExpired bool,
    accountLocked bool,
    disabled bool
);