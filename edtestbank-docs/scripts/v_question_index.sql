SELECT t1.id                                            AS id,
       t1.uuid                                          AS uuid,
       CONCAT(t1.description, SUBSTRING(t2.questionTitle
                                        FROM 1 FOR 30)) AS description,
       t1.date_created                                  AS date_created,
       t1.date_modified                                 AS date_modified
FROM (
         SELECT t.id                     AS id,
                t.uuid                   AS UUID,
                SUBSTRING(t_d.descriptionCtx
                          FROM 1 FOR 30) AS description,
                t.date_created           AS date_created,
                t.date_modified          AS date_modified
         FROM QUESTION t,
              QUESTION_DESCRIPTION t_d
         WHERE t.id = t_d.qIndex_id) t1
         LEFT JOIN QUESTION_TITLE t2 ON t1.id = t2.question_id AND t2.questionNumber = 0;