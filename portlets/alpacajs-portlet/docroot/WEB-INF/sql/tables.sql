create table opencps_dictcollection (
	dictCollectionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	collectionCode VARCHAR(75) null,
	collectionName STRING null,
	description VARCHAR(75) null
);