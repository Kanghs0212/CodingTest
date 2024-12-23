SELECT DEVELOPERS.ID, DEVELOPERS.EMAIL, DEVELOPERS.FIRST_NAME, DEVELOPERS.LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (SELECT SUM(CODE)
                    FROM SKILLCODES
                    WHERE NAME IN ('C#', 'Python'))
ORDER BY ID