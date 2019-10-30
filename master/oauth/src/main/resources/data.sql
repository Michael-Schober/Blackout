INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('SampleID', '$2a$10$V.4NamMx3gFSw/MpH.LZt.qw0LJqCkwEarrq2fYwUJWBf5XmpYka.', null,
	null, null, null, 36000, 36000, null, false);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('CodeID', '$2a$10$V.4NamMx3gFSw/MpH.LZt.qw0LJqCkwEarrq2fYwUJWBf5XmpYka.', 'read,hello',
	'authorization_code,code', 'http://localhost:4200/auth', 'SERVER', 36000, 36000, null, false);