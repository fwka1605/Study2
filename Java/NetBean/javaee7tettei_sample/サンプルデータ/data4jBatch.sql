-- 初期化
DELETE FROM CATEGORY_HAS_KNOWLEDGE;
DELETE FROM CATEGORY;
DELETE FROM KNOWLEDGE_COMMENT;
DELETE FROM KNOWLEDGE;
DELETE FROM ACCOUNT;

-- カテゴリ表
INSERT INTO CATEGORY (ID, NAME) VALUES (1, 'Java');
INSERT INTO CATEGORY (ID, NAME) VALUES (2, 'DB');
INSERT INTO CATEGORY (ID, NAME) VALUES (3, 'FMW');

-- アカウント表
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (1, 'userGroup', 'user001@example.com', '山田一郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'ichiro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (2, 'userGroup', 'user002@example.com', '鈴木二郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'jiro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (3, 'userGroup', 'user003@example.com', '佐藤三郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'saburo');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (4, 'userGroup', 'user004@example.com', '高橋四郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'shiro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (5, 'userGroup', 'user005@example.com', '田中五郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'goro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (6, 'userGroup', 'user006@example.com', '小林六郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'rokuro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (7, 'userGroup', 'user007@example.com', '山本七郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'shichiro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (8, 'userGroup', 'user008@example.com', '中村八郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'hachiro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (9, 'userGroup', 'user009@example.com', '渡辺九郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'kuro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (10,'userGroup', 'user010@example.com', '松本十郎',  '1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'juro');
INSERT INTO ACCOUNT (ID, ACCOUNT_GROUP, MAIL, NAME, PASSWORD, USER_ID) VALUES (11,'userGroup', 'user011@example.com', '吉田十一郎','1ea4b2440d31512b05cc5e55486d627559ed2fa693a14e16212dc80d68c392fa', 'juichiro');

-- ナレッジ表
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1001', 'タイトル1001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1002', 'タイトル1002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1003, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1003', 'タイトル1003', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1004, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1004', 'タイトル1004', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1005, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1005', 'タイトル1005', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1006, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1006', 'タイトル1006', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (1007, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明1007', 'タイトル1007', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 10, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (2001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明2001', 'タイトル2001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 9, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (2002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明2002', 'タイトル2002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 9, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (2003, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明2003', 'タイトル2003', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 9, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (2004, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明2004', 'タイトル2004', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 9, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (2005, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明2005', 'タイトル2005', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 9, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (3001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明3001', 'タイトル3001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 8, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (3002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明3002', 'タイトル3002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 8, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (3003, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明3003', 'タイトル3003', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 8, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (3004, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明3004', 'タイトル3004', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 8, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (4001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明4001', 'タイトル4001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 7, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (4002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明4002', 'タイトル4002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 7, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (4003, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明4003', 'タイトル4003', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 7, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (4004, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明4004', 'タイトル4004', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 7, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (5001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明5001', 'タイトル5001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 6, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (5002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明5002', 'タイトル5002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 6, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (5003, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明5003', 'タイトル5003', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 6, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (6001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明6001', 'タイトル6001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 5, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (6002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明6002', 'タイトル6002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 5, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (7001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明7001', 'タイトル7001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 4, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (7002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明7002', 'タイトル7002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 4, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (8001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明8001', 'タイトル8001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 3, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (8002, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明8002', 'タイトル8002', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 3, '');
INSERT INTO KNOWLEDGE (ID, CREATE_AT, DESCRIPTION, TITLE, UPDATE_AT, ACCOUNT_ID, LAST_COMMENT_AT) VALUES (9001, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), '説明9001', 'タイトル9001', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 2, '');

-- カテゴリ-ナレッジ表
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1001, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1002, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1003, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1004, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1005, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1006, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (1007, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (2001, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (2002, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (2003, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (2004, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (2005, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (3001, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (3002, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (3003, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (3004, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (4001, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (4002, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (4003, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (4004, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (5001, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (5002, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (5003, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (6001, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (6002, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (7001, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (7002, 3);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (8001, 1);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (8002, 2);
INSERT INTO CATEGORY_HAS_KNOWLEDGE (KNOWLEDGELIST_ID, CATEGORYLIST_ID) VALUES (9001, 3);

-- コメント表
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (1,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ01-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (2,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ02-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (3,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ03-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1003');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (4,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ04-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1004');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (9,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ01-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (10, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ02-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (11, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ03-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1003');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (12, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ04-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'1','1004');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (5,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ01-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'2','1001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (6,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ02-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'2','1002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (7,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ03-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'2','1003');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (8,  to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ04-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'2','1004');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (13, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ05-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'2','2001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (14, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ06-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'2','2002');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (15, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ05-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'3','2001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (16, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ06-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'3','2002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (17, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ01-コメント04', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'3','1001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (18, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ02-コメント04', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'3','1002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (19, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ03-コメント04', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'3','1003');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (20, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ07-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'4','4001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (21, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ08-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'4','4002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (22, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ09-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'4','4003');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (23, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ10-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'4','4004');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (24, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ07-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'5','4001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (25, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ08-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'5','4002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (26, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ09-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'5','4003');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (27, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ10-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'5','4004');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (28, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ07-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'6','4001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (29, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ08-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'6','4002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (30, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ09-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'6','4003');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (31, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ10-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'6','4004');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (32, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ11-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'7','5001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (33, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ12-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'7','5002');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (34, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ13-コメント01', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'7','5003');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (35, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ11-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'8','5001');
INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (36, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ12-コメント02', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'8','5002');

INSERT INTO KNOWLEDGE_COMMENT (ID, CREATE_AT, MESSAGE, UPDATE_AT, ACCOUNT_ID, KNOWLEDGE_ID) VALUES (37, to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'), 'ナレッジ11-コメント03', to_timestamp('2015-03-10 12:34:56', 'yyyy/mm/dd hh24:mi:ss'),'9','5001');

commit;
-- exit;
